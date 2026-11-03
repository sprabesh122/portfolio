# DevProfile Architecture

## Design Source of Truth

**Approved Figma design** is the visual and product source of truth for this application.

## Recommended Architecture

**Pragmatic MVVM with Unidirectional Data Flow (UDF)**

### Why Pragmatic MVVM + UDF?

**MVVM Benefits:**
- Separation of Concerns: UI logic separate from business logic
- Testability: ViewModels easily unit tested
- Lifecycle Awareness: ViewModel survives configuration changes
- State Management: Single source of truth for screen state

**Unidirectional Data Flow Benefits:**
- Predictability: State flows in one direction
- Debuggability: Easy to trace state changes
- Maintainability: Clear data flow prevents spaghetti code
- Compose Alignment: Compose's recomposition model aligns with UDF

**Pragmatic Approach:**
- Avoid unnecessary Clean Architecture ceremony
- Do NOT introduce by default: Room, Retrofit, Hilt, Paging, WorkManager, domain/use-case layers, repository layers for static data
- Use MVVM + UDF where mutable state exists
- Static content in simple data classes, no repositories

---

## Technology Classification

### Essential (Must Have)
1. **Kotlin** - Primary language (already in project)
2. **Jetpack Compose** - UI framework (already in project)
3. **Material 3** - Design system (already in project)
4. **Navigation Compose** - Navigation (need to add)
5. **ViewModel** - State management (need to add where mutable state exists)
6. **StateFlow** - Reactive state (need to add where mutable state exists)
7. **Kotlin Coroutines** - Async operations (need to add where async operations exist)
8. **DataStore** - Preference storage for SYSTEM/LIGHT/DARK theme preference (required for persistent theme)

**Why Essential:**
- Core to modern Android development
- Required for professional portfolio
- Demonstrates fundamental Android skills
- DataStore required for persistent theme preference

---

### Recommended (Strong Value for This Project)
1. **SavedStateHandle** - State restoration for nested project navigation (projectId, entry origin)

**Why Recommended:**
- Essential for robust state restoration
- Demonstrates lifecycle knowledge
- Required for nested navigation state

**When to Add:**
- SavedStateHandle: When implementing nested project navigation

---

### Conditional (Add Only If Justified)
1. **Room** - Local persistence (only if adding user-generated content or CMS sync)
2. **Retrofit** - Networking (only if fetching from remote API)
3. **Hilt** - Dependency injection (only if dependency graph becomes complex)
4. **Paging** - Pagination (only if 50+ items)
5. **WorkManager** - Background work (only if implementing sync)

**Why Conditional:**
- Not needed for static portfolio content
- Would add unnecessary complexity
- Can be added later if requirements change

---

### Not Required (Avoid)
1. **LiveData** - StateFlow is superior for Compose
2. **RxJava** - Coroutines are the modern standard
3. **Data Binding** - Compose replaces this
4. **Fragment** - Compose Navigation replaces this
5. **SharedPreferences** - DataStore is the modern replacement
6. **Repository layers for static portfolio data** - Unnecessary abstraction
7. **Domain/use-case layers** - Unnecessary abstraction for static data
8. **Fake loading/error states** - No fake content

**Why Not Required:**
- Older or redundant technologies
- Compose has modern alternatives
- Would demonstrate outdated knowledge
- Unnecessary abstraction for static data

---

## ViewModel vs Repository/Database Distinction

### Core Principles

**1. ViewModel: Owner of Screen UI State**
- **Responsibility:** Manages state for a single screen
- **Scope:** Screen-level (survives configuration changes)
- **Data Source:** Receives data from repositories or generates data locally
- **State Type:** UI state (what the screen displays)
- **Lifecycle:** Created when screen is created, cleared when screen is finished

**Example:**
```kotlin
class ProjectsViewModel(
    private val projectRepository: ProjectRepository
) : ViewModel() {
    // UI state - what the screen displays
    private val _uiState = MutableStateFlow<ProjectsUiState>(ProjectsUiState())
    val uiState: StateFlow<ProjectsUiState> = _uiState.asStateFlow()
    
    // Screen-level business logic
    fun onSearchQueryChanged(query: String) {
        // Update UI state based on search
    }
}
```

**2. Repository/Database: Source of Application Data**
- **Responsibility:** Provides application data (business data)
- **Scope:** Application-level (singleton, shared across screens)
- **Data Source:** Database, API, file system, or in-memory
- **Data Type:** Domain data (projects, case studies, decisions)
- **Lifecycle:** Application lifetime

**Example:**
```kotlin
class ProjectRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    // Domain data - what the application stores
    fun getProjects(): Flow<List<Project>> {
        // Combine local and remote data
    }
}
```

**3. Separation of Concerns**
- **ViewModel:** Manages UI state (loading, error, filtered lists)
- **Repository:** Manages domain data (projects, case studies, decisions)
- **Database:** Persists domain data (if needed)
- **UI:** Displays UI state, sends events to ViewModel

**Data Flow:**
```
UI Event (user action)
    ↓
ViewModel (processes event, updates UI state)
    ↓
Repository (if data needed, fetches domain data)
    ↓
Database/API (returns domain data)
    ↓
Repository (transforms domain data)
    ↓
ViewModel (updates UI state with domain data)
    ↓
UI (recomposes with new UI state)
```

**Key Distinction:**
- **UI State:** Transient, screen-specific (search query, filter selection, loading status)
- **Domain Data:** Persistent, application-wide (projects, case studies, technical decisions)

**When Repository Is Not Needed:**
- For static content (no data fetching or transformation)
- For simple apps with no data layer
- For this MVP: Static content in data classes, no repository needed

---

## UI State: Sealed Classes vs Data Classes

### Sealed Classes for UI State

**When to Use:**
- When UI has distinct, mutually exclusive states
- When states carry different data
- When exhaustive handling is beneficial

**Example:**
```kotlin
sealed class ProjectsUiState {
    data object Loading : ProjectsUiState()
    data class Success(val projects: List<Project>) : ProjectsUiState()
    data class Error(val message: String) : ProjectsUiState()
}
```

**Advantages:**
- Type-safe exhaustive when expressions
- Each state can carry different data
- Clear state transitions
- Compiler ensures all states are handled

**Disadvantages:**
- More verbose for simple cases
- Overkill for states that always have the same shape

**Appropriate For:**
- Screens with loading/success/error states
- Screens with distinct modes (empty, content, error)
- Screens where states have different data shapes

---

### Data Classes for UI State

**When to Use:**
- When UI state is always the same shape
- When all fields are present in all states
- When state is simple and uniform

**Example:**
```kotlin
data class ProjectsUiState(
    val searchQuery: String = "",
    val selectedFilter: String = "all",
    val visibleProjects: List<Project> = emptyList()
)
```

**Advantages:**
- Simpler for uniform state
- Less boilerplate
- Easy to update individual fields
- Clear what fields exist

**Disadvantages:**
- No exhaustive handling
- Can represent invalid states
- Less explicit about state transitions

**Appropriate For:**
- Screens with simple, uniform state
- Screens where all fields are always relevant
- Screens without distinct modes

---

### Comparison and Recommendation

**Use Sealed Classes When:**
- Screen has distinct modes (loading, success, error, empty)
- Each mode carries different data
- You want exhaustive handling
- State transitions are important

**Use Data Classes When:**
- State is always the same shape
- All fields are present in all states
- State is simple and uniform
- You prefer simplicity over exhaustive handling

**Recommendation for This Project:**
- **MVP:** Use data classes for simple screens (static content)
- **Intermediate:** Use data classes for search/filter state (uniform shape)
- **Advanced:** Use sealed classes if loading/error states are added (if dynamic data)

**Example Decision:**
- **Home Screen (static):** No state class needed
- **Projects Screen (with search/filter):** Data class (searchQuery, selectedFilter, visibleProjects)
- **Case Study Detail (static):** No state class needed
- **Engineering Screen (static):** No state class needed

---

## Lifecycle Concepts: Clear Distinctions

### 1. Configuration Changes
**What:** Device configuration changes that recreate the Activity
**Examples:** Screen rotation, language change, theme change, multi-window mode
**Behavior:** Activity is destroyed and recreated
**State Survival:** ViewModel survives (by design)
**Handling Needed:** ViewModel automatically survives, no special handling needed
**Storage:** ViewModel retains state in memory

**Example:**
```kotlin
// ViewModel survives configuration change
class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(...)
    // State survives rotation automatically
}
```

---

### 2. Process Death
**What:** System kills the entire application process (not just Activity)
**Examples:** Low memory, system optimization, user swipes app away
**Behavior:** Entire application process is killed, including ViewModel
**State Survival:** ViewModel is destroyed
**Handling Needed:** Use SavedStateHandle to restore state
**Storage:** SavedStateHandle uses saved instance state (persisted by system)

**Example:**
```kotlin
class HomeViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    // Restore from SavedStateHandle
    private val searchQuery: String = savedStateHandle["search_query"] ?: ""
    
    // Save to SavedStateHandle
    fun onSearchQueryChanged(query: String) {
        savedStateHandle["search_query"] = query
    }
}
```

---

### 3. SavedStateHandle
**What:** A key-value map that survives process death
**Scope:** ViewModel-scoped
**Persistence:** Survives process death, not app uninstall
**Capacity:** Limited (use for small amounts of data)
**Use For:** Navigation arguments, search queries, filter selections, scroll position

**Example:**
```kotlin
class ProjectsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var searchQuery by savedStateHandle.saveable("search_query") { "" }
    var selectedFilter by savedStateHandle.saveable("selected_filter") { "all" }
}
```

---

### 4. Persistent Storage
**What:** Long-term storage that survives app uninstall (if not cleared)
**Examples:** Room database, DataStore, files
**Scope:** Application-level
**Persistence:** Survives process death, app restart, device restart
**Capacity:** Large (can store significant data)
**Use For:** User data, preferences, cached content, application data

**Example:**
```kotlin
// DataStore for preferences
class PreferencesManager(private val dataStore: DataStore<Preferences>) {
    val themeMode: Flow<ThemeMode> = dataStore.data.map {
        it[THEME_MODE_KEY] ?: ThemeMode.SYSTEM
    }
    
    suspend fun setThemeMode(mode: ThemeMode) {
        dataStore.edit { it[THEME_MODE_KEY] = mode }
    }
}
```

---

### Comparison Summary

| Concept | Trigger | What Dies | What Survives | Storage Mechanism | Use For |
|---------|---------|-----------|---------------|-------------------|---------|
| Configuration Change | Rotation, theme | Activity | ViewModel | In-memory | Screen state |
| Process Death | Low memory | Process, ViewModel | SavedStateHandle | System saved state | Navigation args, small UI state |
| Persistent Storage | N/A | Nothing (unless cleared) | Everything | Database/DataStore | User data, preferences, content |

**Key Insight:**
- **Configuration Change:** ViewModel handles it automatically
- **Process Death:** SavedStateHandle handles it (you must implement)
- **Persistent Storage:** Database/DataStore handles it (you must implement)

**Recommendation for This Project:**
- **MVP:** Rely on ViewModel for configuration changes (automatic)
- **Intermediate:** Add SavedStateHandle for search/filter state restoration
- **Advanced:** Add DataStore only if persistent user-selected theme preference needed

---

## Package Structure

**Suggested Package Direction:**

```
com.example.portfolio/
├── MainActivity.kt
├── app/
├── navigation/
├── data/
│   └── model/          # Data classes for static content
├── feature/
│   ├── home/           # Home screen
│   ├── education/      # Education screen
│   ├── experience/     # Experience screen
│   ├── projects/       # Projects screen + nested project screens
│   └── about/          # About screen
├── ui/
│   ├── component/      # Reusable Composables
│   └── theme/          # Theme (already exists)
└── preferences/        # Theme preference management
```

**Do not create every package/file upfront unless needed by the current milestone.**

**Package Responsibilities:**
- `data/model/` - Simple data classes for static portfolio content
- `feature/` - Feature-oriented packages (home, education, experience, projects, about)
- `ui/component/` - Reusable Composable components (extracted after demonstrated repetition)
- `ui/theme/` - Theme, colors, typography, spacing, shapes
- `navigation/` - Navigation Compose graph
- `preferences/` - Theme preference management with DataStore

**Simplification Note:**
- Many screens may not need ViewModels if content is static
- Repository layer not needed for static portfolio data
- Domain/use-case layers not needed for static data
- Add layers only when they provide meaningful separation

---

## Static Content Architecture

**Principle:** Keep static portfolio content in simple Kotlin data classes. Do not introduce repositories or domain/use-case layers unless they solve an actual problem.

**Static Data Examples:**
- Education
- Experience
- Awards
- Skills
- Projects (Flow project data truth)
- Engineering highlights
- Contact

**Example:**
```kotlin
// data/model/Project.kt
data class Project(
    val id: String,
    val title: String,
    val subtitle: String,
    val status: ProjectStatus,
    val demoUrl: String?,
    val playStoreUrl: String?,
    val sourceUrl: String?,
    val listingVerified: Boolean
)

enum class ProjectStatus {
    IN_PROGRESS,
    PUBLISHED,
    ARCHIVED
}

// Static data
val flowProject = Project(
    id = "flow",
    title = "Flow",
    subtitle = "Automatic Expense Tracker",
    status = ProjectStatus.IN_PROGRESS,
    demoUrl = null,
    playStoreUrl = null,
    sourceUrl = null,
    listingVerified = false
)
```

**When to Add Repository:**
- Only if data needs to be fetched from remote source
- Only if data needs to be transformed significantly
- Only if data needs to be cached locally

**For This Project:**
- Static content in data classes, no repository
- Do not invent fake data (URLs, build percentages, achievements, metrics)
- Flow project data truth must be preserved

---

## Dependency Direction

```
UI Layer (Screens, ViewModels)
    ↓ depends on
Data Layer (Data Classes)
```

**Principles:**
- UI depends on Data, not vice versa
- ViewModels depend on data classes
- Data classes have no UI dependencies
- Models are shared across layers

---

## Data Flow

### Unidirectional Data Flow Example

```
User Action (Button Tap)
    ↓
Composable Event (onClick)
    ↓
ViewModel Function (onProjectClicked)
    ↓
Business Logic / State Update
    ↓
State Update (_uiState.value = newState)
    ↓
StateFlow Emits New State
    ↓
Composable Recomposes with New State
    ↓
UI Updates
```

**Key Principles:**
- State flows down (ViewModel → UI)
- Events flow up (UI → ViewModel)
- UI is immutable representation of state
- ViewModel is single source of truth

---

## Navigation Architecture

### Navigation Compose Structure

```kotlin
@Composable
fun PortfolioNavGraph() {
    val navController = rememberNavController()
    
    NavHost(navController, startDestination = "home") {
        // Primary destinations (5, in order)
        composable("home") { HomeScreen(...) }
        composable("education") { EducationScreen(...) }
        composable("experience") { ExperienceScreen(...) }
        composable("projects") { ProjectsScreen(...) }
        composable("about") { AboutScreen(...) }
        
        // Nested project destinations (generic projectId)
        composable("project/{projectId}") {
            ProjectDetailScreen(
                projectId = it.arguments?.getString("projectId") ?: "flow"
            )
        }
        composable("project/{projectId}/demo") {
            ProjectDemoStatusScreen(
                projectId = it.arguments?.getString("projectId") ?: "flow"
            )
        }
    }
}
```

**Navigation Behavior:**
- launchSingleTop for primary tab navigation
- Save/restore state between primary destinations
- Preserve scroll position independently for each primary destination
- Selecting currently active tab is a no-op
- System Back from non-Home primary tab returns Home
- System Back from Home exits
- Nested project Detail Back returns to entry origin
- Demo Back returns to project Detail
- Explicit "Back to Projects" clears nested flow and selects Projects
- Predictive back follows equivalent behavior

**Do not pass NavController deep into screen composables. Screens should expose navigation callbacks.**

**Bottom Navigation Integration:**
- 5-item floating bottom navigation
- Wrap NavHost in Scaffold with BottomNavigation
- Use `navController.currentBackStackEntry` to track current destination
- Update selected item in BottomNavigation

---

## State Management Approach

### UI State Pattern

**Data Class for State (Simple Cases):**
```kotlin
data class ProjectsUiState(
    val searchQuery: String = "",
    val selectedFilter: String = "all",
    val visibleProjects: List<CaseStudy> = emptyList()
)
```

**ViewModel StateFlow:**
```kotlin
private val _uiState = MutableStateFlow(ProjectsUiState())
val uiState: StateFlow<ProjectsUiState> = _uiState.asStateFlow()
```

**Composable Collection:**
```kotlin
val uiState by viewModel.uiState.collectAsStateWithLifecycle()
```

**Separation of Source Data:**
```kotlin
class ProjectsViewModel : ViewModel() {
    // Source data (static, not duplicated in UI state)
    private val allCaseStudies = CaseStudyData.allCaseStudies
    
    // UI state (derived from source data)
    private val _uiState = MutableStateFlow(ProjectsUiState())
    val uiState: StateFlow<ProjectsUiState> = _uiState.asStateFlow()
    
    fun onSearchQueryChanged(query: String) {
        _uiState.update { currentState ->
            currentState.copy(
                searchQuery = query,
                visibleProjects = filterProjects(query, currentState.selectedFilter)
            )
        }
    }
    
    private fun filterProjects(query: String, filter: String): List<CaseStudy> {
        return allCaseStudies.filter { /* filter logic */ }
    }
}
```

**Why This Pattern:**
- Type-safe state
- Explicit state structure
- Immutable state
- Lifecycle-aware collection
- Source data not duplicated in UI state

---

## Testing Strategy

### Phase 1 (MVP): No Testing
- Focus on implementation first
- Testing added in later milestones

### Phase 2 (Intermediate): Testing with Existing Dependencies
- Use existing JUnit 4 for unit tests
- Use existing Compose testing for UI tests
- Prefer fake implementations over mocks

### Phase 3 (Advanced): Additional Testing Tools (Conditional)
- Add coroutine testing dependencies if needed
- Add MockK and Turbine only if fakes insufficient

**Tools:**
- JUnit 4 (already present)
- Compose UI Testing (already present)
- MockK (optional, if needed)
- Turbine (optional, if needed)

---

## Architecture Trade-offs

### Decision: Single Module vs Multi-Module
**Choice:** Single module
**Why:**
- Simpler for portfolio app
- Faster build times
- Easier to understand
- Multi-module adds complexity without clear benefit for this scale

### Decision: Repository Pattern
**Choice:** Use only when meaningful separation exists
**Why:**
- For static portfolio data, repository is overkill
- For offline-first with sync, repository is valuable
- Don't add abstraction without need

### Decision: Data Class vs Sealed Class for UI State
**Choice:** Data class for simple uniform state
**Why:**
- Simpler for search/filter state
- Less boilerplate
- Sealed classes only if distinct modes needed

### Decision: Static Content in Data Classes
**Choice:** Simple data classes, no repository
**Why:**
- No data fetching or transformation needed
- No need for abstraction layers
- Add repository only if remote data or transformation needed

### Decision: Feature-Oriented Package Structure
**Choice:** Feature packages (home, education, experience, projects, about)
**Why:**
- Clear feature boundaries
- Easier to navigate
- Scales better than UI-centric packages
- Aligns with feature development

### Decision: Reusable Components Extracted After Repetition
**Choice:** Extract components only after demonstrated repetition
**Why:**
- Avoids premature abstraction
- Components extracted based on actual need
- Simpler initial implementation
- Reduces unnecessary complexity

### Decision: DataStore for Theme Preference
**Choice:** DataStore for SYSTEM/LIGHT/DARK theme preference
**Why:**
- Persistent user state requires DataStore
- System theme support requires Android integration
- Modern replacement for SharedPreferences
- Required for MVP theme preference
