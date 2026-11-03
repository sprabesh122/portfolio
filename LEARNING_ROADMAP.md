# DevProfile Learning Roadmap

## Completed Stages

**Stage 1: Figma Design Audit** - COMPLETE
**Stage 2: Application Structure/State Ownership** - COMPLETE
**Stage 3: Documentation Alignment** - COMPLETE

No production source code or Gradle changes were made during Stages 1-3.

---

## Milestone 4: Compose Fundamentals + Static Home Implementation

**Topic:** Building Home screen with Compose fundamentals

**Learning Objectives:**
- Understand Composable functions
- Use layout components (Column, Row, Box)
- Apply modifiers (padding, fillMaxWidth)
- Understand composition basics
- Implement Home screen per Figma design

**Concepts to Understand:**
- Composable function structure
- Layout composition (Column, Row, Box)
- Modifier chain and order
- Composition vs recomposition (introductory)

**Why It Matters:**
- Foundation for all Compose UI work
- Required before adding complexity
- First screen implementation

**Where Used:**
- Home screen

**Files/Components Involved:**
- `feature/home/HomeScreen.kt` (new)
- `data/model/Profile.kt` (new - data class)

**Practical Implementation Task:**
1. Create data class for profile information
2. Create HomeScreen Composable with static content per Figma
3. Implement profile/hero section
4. Implement production impact section
5. Implement recognition preview
6. Implement daily toolkit
7. Implement Flow preview
8. Apply spacing per design tokens

**Expected Outcome:**
- Home screen displays static content matching Figma
- Layout is structured and readable
- Content is scrollable
- No crashes

**Validation Criteria:**
- Home screen renders correctly
- Layout matches Figma structure
- Spacing follows design tokens
- Content is visible

**Interview Questions After This Milestone:**
- What is a Composable function?
- How does Column differ from Row?
- What is the purpose of modifiers?
- When does composition happen vs recomposition?

**Prerequisites for Moving Forward:**
- Home screen displays static content
- Understanding of basic Compose concepts

---

## Milestone 5: Remaining Static Primary Screens

**Topic:** Building Education, Experience, Projects, and About screens with static content

**Learning Objectives:**
- Create multiple screens with similar patterns
- Use LazyColumn for scrollable lists
- Maintain consistency across screens
- Organize static content in data classes

**Concepts to Understand:**
- LazyColumn vs Column
- Data classes for static content
- Screen organization
- Content structure

**Why It Matters:**
- Builds complete UI foundation
- Demonstrates ability to structure content
- Required before adding navigation

**Where Used:**
- Education screen
- Experience screen
- Projects screen
- About screen

**Files/Components Involved:**
- `feature/education/EducationScreen.kt` (new)
- `feature/experience/ExperienceScreen.kt` (new)
- `feature/projects/ProjectsScreen.kt` (new)
- `feature/about/AboutScreen.kt` (new)
- `data/model/Education.kt` (new - data class)
- `data/model/Experience.kt` (new - data class)
- `data/model/Project.kt` (new - data class)
- `data/model/Skill.kt` (new - data class)

**Practical Implementation Task:**
1. Create data classes for education, experience, projects, skills
2. Create EducationScreen with timeline (LazyColumn)
3. Create ExperienceScreen with employment history (LazyColumn)
4. Create ProjectsScreen with Flow project presentation
5. Create AboutScreen with profile, principles, skills, contact
6. Maintain consistent spacing and typography
7. Ensure all screens display static content correctly

** Expected Outcome:**
- All 4 screens display static content matching Figma
- Content is scrollable where needed
- UI is consistent across screens
- Data classes are simple and clean

**Validation Criteria:**
- All screens render correctly
- LazyColumn works for lists
- Data classes are structured properly
- UI is consistent

**Interview Questions After This Milestone:**
- When should you use LazyColumn vs Column?
- How do you organize static content in Compose?
- What are the performance implications of LazyColumn?

**Prerequisites for Moving Forward:**
- All 5 primary screens display static content
- Understanding of LazyColumn and data classes

---

## Milestone 6: Extract Demonstrated Reusable Components

**Topic:** Extracting reusable Composable components after repetition is demonstrated

**Learning Objectives:**
- Identify repeated patterns across screens
- Extract reusable components
- Make components stateless
- Use parameters for customization
- Ensure component stability

**Concepts to Understand:**
- Component reusability
- State hoisting in components
- Composable parameters
- Component stability
- When to extract vs when to keep inline

**Why It Matters:**
- Maintainable codebase
- Consistent UI across screens
- Demonstrates Compose best practices
- Avoids premature abstraction

**Where Used:**
- PortfolioAppBar, PSMonogram, ThemeControl, FloatingPortfolioNavigation, SectionHeader, PortfolioPanel, Tag, etc.

**Files/Components Involved:**
- `ui/component/PortfolioAppBar.kt` (new - if demonstrated)
- `ui/component/PSMonogram.kt` (new - if demonstrated)
- `ui/component/ThemeControl.kt` (new - if demonstrated)
- `ui/component/FloatingPortfolioNavigation.kt` (new - if demonstrated)
- Other components as repetition is demonstrated

**Practical Implementation Task:**
1. Review screens for repeated patterns
2. Extract PortfolioAppBar if used across screens
3. Extract PSMonogram if used multiple times
4. Extract ThemeControl if used multiple times
5. Extract FloatingPortfolioNavigation
6. Extract other components as repetition is demonstrated
7. Refactor screens to use extracted components
8. Ensure components are stateless

**Expected Outcome:**
- Components reused where repetition exists
- UI is consistent
- Code is maintainable
- Components are stable
- No premature extraction

**Validation Criteria:**
- Components extracted only after demonstrated repetition
- UI is consistent
- No unnecessary abstraction
- Components are stateless

**Interview Questions After This Milestone:**
- What makes a Composable stable?
- Why should components be stateless?
- What is state hoisting?
- When should you extract a component vs keep it inline?

**Prerequisites for Moving Forward:**
- Reusable components extracted based on demonstrated need
- Understanding of component stability
- Understanding of when to abstract

---

## Milestone 7: Navigation Compose

**Topic:** Implementing Navigation Compose with 5-item floating bottom navigation

**Learning Objectives:**
- Set up Navigation Compose graph
- Implement 5-item floating bottom navigation
- Connect all primary screens to navigation
- Handle back navigation per contract
- Implement nested project routes with projectId

**Concepts to Understand:**
- NavHost and NavController
- Navigation routes
- Bottom navigation integration
- Back stack management
- launchSingleTop behavior
- Navigation arguments (projectId)

**Why It Matters:**
- Connects screens into a cohesive app
- Standard navigation pattern in modern Android
- Required for multi-screen applications

**Where Used:**
- All screen navigation
- Floating bottom navigation bar
- Nested project navigation

**Files/Components Involved:**
- `navigation/NavGraph.kt` (new)
- `MainActivity.kt` (modify)

**Practical Implementation Task:**
1. Create NavGraph.kt with NavHost
2. Define routes for 5 primary screens (home, education, experience, projects, about)
3. Define nested routes for project detail and demo status with projectId
4. Add 5-item floating bottom navigation to Scaffold
5. Connect bottom navigation to NavHost
6. Implement launchSingleTop behavior
7. Test navigation between screens
8. Test back navigation per contract
9. Test nested project navigation

**Expected Outcome:**
- Floating bottom navigation switches between 5 screens
- All screens accessible via navigation
- Back button behaves per contract
- Nested navigation works with projectId
- No navigation crashes

**Validation Criteria:**
- Navigation works between all primary screens
- Bottom navigation updates correctly
- Back stack behaves per contract
- Nested navigation accepts projectId
- No crashes

**Interview Questions After This Milestone:**
- How does NavHost differ from NavController?
- What is a navigation route?
- How does the back stack work in Navigation Compose?
- How do you handle bottom navigation state?
- What is launchSingleTop and when is it useful?

**Prerequisites for Moving Forward:**
- Navigation working between all screens
- Understanding of back stack management
- Understanding of navigation arguments

---

## Milestone 8: Final Custom Design System / Theming

**Topic:** Implementing approved Figma design system with custom colors, typography, spacing

**Learning Objectives:**
- Implement approved semantic color tokens
- Implement Inter and Roboto Mono typography
- Implement spacing rhythm (4/8/12/16/20/24/32 dp)
- Implement geometry (screen inset, section gap, panel padding, etc.)
- Support light and dark themes
- Apply shape language

**Concepts to Understand:**
- Material 3 color system override
- Custom typography with multiple font families
- Design tokens (spacing, geometry, shapes)
- Theme composition
- Light/dark theme implementation

**Why It Matters:**
- Matches approved Figma design
- Professional visual design
- Demonstrates design system knowledge
- Differentiates from default templates

**Where Used:**
- All screens (global theme)

**Files/Components Involved:**
- `ui/theme/Color.kt` (modify)
- `ui/theme/Theme.kt` (modify)
- `ui/theme/Type.kt` (modify)
- `ui/theme/Spacing.kt` (new - if needed)
- `ui/theme/Shape.kt` (new - if needed)

**Practical Implementation Task:**
1. Implement approved semantic color tokens (canvas, surface, raised, border, text, muted, accent, etc.)
2. Update Color.kt with approved palette for light and dark
3. Modify Theme.kt to use custom colors
4. Implement Inter font for main UI/content
5. Implement Roboto Mono for technical metadata
6. Update typography scale
7. Implement spacing rhythm constants
8. Implement geometry constants
9. Implement shape language constants
10. Test light and dark themes
11. Apply design tokens across screens

**Expected Outcome:**
- App uses approved Figma colors
- Light and dark themes work correctly
- Typography uses Inter and Roboto Mono
- Spacing follows approved rhythm
- Geometry matches specifications
- Shapes follow language

**Validation Criteria:**
- Custom colors match Figma exactly
- Both themes look good and match Figma
- Typography is readable and uses correct fonts
- Spacing follows rhythm
- Geometry matches specifications

**Interview Questions After This Milestone:**
- How do you implement multiple font families in Compose?
- How do you ensure design tokens are used consistently?
- What is the difference between semantic and literal colors?
- How do you test light and dark themes?

**Prerequisites for Moving Forward:**
- Custom design system implemented matching Figma
- Understanding of Material 3 theming
- Understanding of design tokens

---

## Milestone 9: Coroutines Fundamentals

**Topic:** Understanding coroutines before using them in ViewModels

**Learning Objectives:**
- Understand coroutine scope and context
- Learn about dispatchers (Main, IO, Default)
- Understand structured concurrency
- Learn exception handling in coroutines
- Understand cancellation

**Concepts to Understand:**
- CoroutineScope
- CoroutineContext
- Dispatchers
- Structured concurrency
- Exception handling
- Cancellation

**Why It Matters:**
- Foundation for async operations
- Required before ViewModel implementation
- Essential for modern Android development

**Where Used:**
- Future: ViewModels with async operations

**Files/Components Involved:**
- No implementation yet (conceptual learning)

**Practical Learning Task:**
1. Study coroutine basics through explanation
2. Understand viewModelScope vs lifecycleScope
3. Learn about dispatchers and when to use each
4. Understand structured concurrency principles
5. Learn exception handling patterns

**Expected Outcome:**
- Understanding of coroutine fundamentals
- Knowledge of when to use different scopes
- Understanding of structured concurrency

**Validation Criteria:**
- Can explain coroutine scope and context
- Can explain when to use different dispatchers
- Understands structured concurrency

**Interview Questions After This Milestone:**
- What is a coroutine scope?
- What is the difference between Main and IO dispatchers?
- What is structured concurrency?
- How do you handle exceptions in coroutines?

**Prerequisites for Moving Forward:**
- Understanding of coroutine fundamentals
- Ready to apply in ViewModels

---

## Milestone 10: ViewModel + StateFlow

**Topic:** Implementing ViewModel with StateFlow for mutable UI state

**Learning Objectives:**
- Create ViewModel with StateFlow
- Define UI state (data class for simple cases)
- Collect state in Composable
- Understand ViewModel lifecycle
- Handle state updates
- Keep static source data separate from UI state

**Concepts to Understand:**
- ViewModel lifecycle and scope
- StateFlow vs LiveData
- MutableStateFlow vs StateFlow
- collectAsStateWithLifecycle()
- Data class vs sealed class for UI state
- Separation of source data from UI state

**Why It Matters:**
- Foundation for state management
- Required for mutable features (theme preference)
- Demonstrates modern Android architecture

**Where Used:**
- Theme preference state (if needed)
- Any future mutable UI state

**Files/Components Involved:**
- `preferences/ThemeViewModel.kt` (new - if needed)
- Other ViewModels as mutable state is needed

**Practical Implementation Task:**
1. Create ViewModel with StateFlow for theme preference
2. Define UI state as data class
3. Keep source data separate from UI state
4. Implement theme preference state management
5. Modify screen to collect state
6. Connect theme control to ViewModel

**Expected Outcome:**
- Theme preference state managed in ViewModel
- UI state exposes derived theme
- UI updates reactively
- State survives configuration changes

**Validation Criteria:**
- State management works correctly
- UI updates reactively
- State survives rotation
- No memory leaks
- Source data not duplicated in UI state

**Interview Questions After This Milestone:**
- Why use StateFlow instead of LiveData with Compose?
- What is the difference between MutableStateFlow and StateFlow?
- Why use collectAsStateWithLifecycle()?
- When would you use sealed classes vs data classes for UI state?
- Why keep source data separate from UI state?

**Prerequisites for Moving Forward:**
- ViewModel with StateFlow implemented
- Understanding of state lifecycle
- Understanding of source data vs UI state separation

---

## Milestone 11: Preferences DataStore for Theme Preference

**Topic:** Storing SYSTEM/LIGHT/DARK theme preference with DataStore

**Learning Objectives:**
- Use Preferences DataStore
- Store and retrieve key-value pairs
- Observe preference changes with Flow
- Apply preferences to UI
- Distinguish stored preference from effective theme

**Concepts to Understand:**
- DataStore vs SharedPreferences
- Preferences DataStore API
- Flow-based preference observation
- Preference application in UI
- SYSTEM theme resolution

**Why It Matters:**
- Modern replacement for SharedPreferences
- Demonstrates current Android knowledge
- Required for persistent theme preference
- SYSTEM theme requires Android system integration

**Where Used:**
- Theme preference (SYSTEM/LIGHT/DARK)

**Files/Components Involved:**
- `preferences/ThemePreferenceManager.kt` (new)
- `PortfolioApplication.kt` (new)
- `ui/theme/Theme.kt` (modify)
- `feature/about/AboutScreen.kt` (modify)

**Practical Implementation Task:**
1. Create ThemePreferenceManager with DataStore
2. Define preference keys (theme mode: SYSTEM, LIGHT, DARK)
3. Implement save and retrieve functions
4. Observe preference changes with Flow
5. Connect theme preference to Theme.kt
6. Implement SYSTEM theme resolution
7. Add theme preference selector in About screen

**Expected Outcome:**
- Theme preference persists across app restarts
- Preference changes update UI reactively
- SYSTEM theme resolves to Android system theme
- DataStore used correctly

**Validation Criteria:**
- Preferences saved correctly
- Preferences persist after app restart
- UI updates when preferences change
- SYSTEM theme works correctly

**Interview Questions After This Milestone:**
- Why use DataStore instead of SharedPreferences?
- How do you observe preference changes?
- What are the advantages of DataStore's Flow-based API?
- How do you resolve SYSTEM theme to effective theme?

**Prerequisites for Moving Forward:**
- DataStore implemented for theme preference
- Understanding of modern Android persistence
- Understanding of SYSTEM theme resolution

---

## Milestone 12: Nested Project Navigation + SavedStateHandle

**Topic:** Implementing nested project navigation with state restoration

**Learning Objectives:**
- Implement nested navigation routes with projectId
- Use SavedStateHandle for transient/restorable state
- Implement state restoration for nested navigation
- Test process death behavior
- Distinguish configuration-change testing from process-death testing

**Concepts to Understand:**
- Nested navigation with Navigation Compose
- Navigation arguments (projectId)
- SavedStateHandle for transient state
- State restoration strategies
- Process death vs configuration change
- Entry origin tracking

**Why It Matters:**
- Required for project detail navigation
- Demonstrates deep Android knowledge
- Common interview topic
- Robust state restoration

**Where Used:**
- Project Detail screen
- Project Demo Status screen
- Navigation state restoration

**Files/Components Involved:**
- `feature/projects/ProjectDetailScreen.kt` (new)
- `feature/projects/ProjectDemoStatusScreen.kt` (new)
- `navigation/NavGraph.kt` (modify)

**Practical Implementation Task:**
1. Implement nested route for project detail with projectId
2. Implement nested route for demo status with projectId
3. Add SavedStateHandle to relevant ViewModels (if any)
4. Save projectId and entry origin to SavedStateHandle
5. Restore state on screen creation
6. Test configuration change (rotation) - verify ViewModel survives
7. Test process death (Don't keep activities) - verify SavedStateHandle restores
8. Verify state is restored correctly in both scenarios

**Expected Outcome:**
- Nested navigation works with projectId
- ProjectId persists after configuration change
- ProjectId persists after process death
- Entry origin tracking works
- User experience is seamless

**Validation Criteria:**
- Nested navigation accepts projectId
- State survives configuration change (ViewModel)
- State survives process death (SavedStateHandle)
- No data loss
- No crashes on restoration
- Distinction between scenarios understood

**Interview Questions After This Milestone:**
- What is the difference between process death and configuration change?
- How does SavedStateHandle work?
- What state should be restored vs what can be discarded?
- How do you test process death vs configuration change?
- Why doesn't rotation alone validate process-death restoration?

**Prerequisites for Moving Forward:**
- Nested navigation working
- State restoration working
- Understanding of Android lifecycle extremes
- Understanding of testing both scenarios

---

## Milestone 13: Interactive Compose/State Demonstrations

**Topic:** Creating interactive demonstrations only where product design requires them

**Condition:** Add only where product design actually requires interactive demonstrations. Do not add generic demos.

**Learning Objectives:**
- Identify where interactive demonstrations add value
- Create interactive demo for specific Compose/state concept
- Visualize concept through interaction
- Explain concept through demo

**Concepts to Understand:**
- When interactive demos are valuable
- State visualization techniques
- Interactive UI patterns
- Concept explanation through interaction

**Why It Matters:**
- Adds value where needed
- Demonstrates teaching ability
- Shows deep Compose knowledge
- Avoids unnecessary complexity

**Where Used:**
- Only where product design requires

**Files/Components Involved:**
- Demonstration screens (only if needed)

**Practical Implementation Task:**
1. Identify if product design requires interactive demonstrations
2. If yes, create specific demo for required concept
3. Visualize concept through interaction
4. Add explanation text
5. Integrate into appropriate screen

**Expected Outcome:**
- Interactive demos only where product requires
- Demonstrations add clear value
- No unnecessary complexity

**Validation Criteria:**
- Demos serve product need
- No generic or unnecessary demos
- Clear value demonstrated

**Interview Questions After This Milestone:**
- When are interactive demonstrations valuable?
- How do you determine if a demo is needed?
- How do you balance complexity with value?

**Prerequisites for Moving Forward:**
- Interactive demos only where product requires
- Understanding of when to add complexity

---

## Milestone 14: Accessibility/Adaptive Layout Hardening

**Topic:** Implementing accessibility and adaptive layout requirements

**Learning Objectives:**
- Implement accessibility requirements (48×48dp targets, TalkBack, semantics)
- Implement adaptive layout for different screen sizes
- Test up to 200% font scale
- Preserve state across rotation
- Ensure appropriate contrast

**Concepts to Understand:**
- Accessibility requirements (targets, TalkBack, semantics)
- Adaptive layout patterns
- Font scale handling
- Contrast requirements
- State preservation across rotation

**Why It Matters:**
- Required for professional apps
- Demonstrates inclusive design
- Required for release readiness
- Common interview topic

**Where Used:**
- All screens

**Files/Components Involved:**
- All screen composables
- Theme files (contrast)

**Practical Implementation Task:**
1. Ensure minimum 48×48dp interactive bounds
2. Implement meaningful TalkBack order
3. Add selected semantics for navigation/theme controls
4. Hide decorative icons from accessibility when parent has label
5. Make whole row links clickable
6. Mark headings semantically
7. Add persistent unavailable/error text
8. Ensure appropriate contrast
9. Implement adaptive layout for 360-599dp (single column, 20dp sides)
10. Implement adaptive layout for ≥600dp (center content, max 480dp)
11. Test up to 200% font scale
12. Preserve state across rotation
13. Ensure tags/chips wrap
14. Ensure cards/actions grow with content
15. Never shrink typography to fit content

**Expected Outcome:**
- Accessibility requirements met
- Adaptive layout works for different screen sizes
- Font scale tested up to 200%
- State preserved across rotation
- Contrast is appropriate

**Validation Criteria:**
- All interactive targets meet 48×48dp minimum
- TalkBack order is meaningful
- Semantics are correct
- Adaptive layout works for breakpoints
- Font scale tested
- State preserved across rotation
- Contrast meets requirements

**Interview Questions After This Milestone:**
- What are the key accessibility requirements?
- How do you implement adaptive layouts?
- How do you test font scale?
- How do you preserve state across rotation?

**Prerequisites for Moving Forward:**
- Accessibility requirements met
- Adaptive layout implemented
- Understanding of inclusive design

---

## Milestone 15: Testing

**Topic:** Writing tests using existing JUnit 4 and Compose testing

**Learning Objectives:**
- Use existing JUnit 4 for unit tests
- Use existing Compose testing for UI tests
- Write simple unit tests
- Write simple UI tests
- Understand testing basics

**Concepts to Understand:**
- JUnit 4 basics
- Compose testing semantics
- Finding elements with tags
- Performing actions
- Assertions
- Fake implementations vs mocks

**Why It Matters:**
- Essential for code quality
- Demonstrates testing maturity
- Uses existing dependencies

**Where Used:**
- Simple unit tests for logic
- UI tests for critical components

**Files/Components Involved:**
- Unit tests as needed
- UI tests as needed

**Practical Implementation Task:**
1. Write simple unit tests for critical logic
2. Write simple UI tests for critical components
3. Use fake implementations instead of mocks
4. Test critical user flows
5. Verify tests pass

**Expected Outcome:**
- Unit tests pass
- UI tests pass
- Tests cover important scenarios
- No additional dependencies added

**Validation Criteria:**
- Tests pass successfully
- Tests are maintainable
- Tests use existing dependencies

**Interview Questions After This Milestone:**
- How do you test Composable functions?
- What are semantics in Compose testing?
- When would you use fake implementations vs mocks?

**Prerequisites for Moving Forward:**
- Tests written with existing dependencies
- Understanding of testing basics

---

## Milestone 16: Final Polish/Release Readiness

**Topic:** Final polish and release readiness

**Learning Objectives:**
- Review all screens for polish
- Ensure no fake content
- Verify Flow project data truth
- Test all user flows
- Prepare for release

**Concepts to Understand:**
- Release readiness criteria
- Quality assurance
- User flow testing
- Data verification

**Why It Matters:**
- Required for professional release
- Demonstrates attention to detail
- Final validation of implementation

**Where Used:**
- Entire application

**Files/Components Involved:**
- All files as needed for polish

**Practical Implementation Task:**
1. Review all screens for polish
2. Ensure no fake content (no fake demo, fake loading, fake video, fake progress, fake URLs, fake store listing)
3. Verify Flow project data truth (status IN_PROGRESS, URLs null, listingVerified false)
4. Test all user flows
5. Verify accessibility
6. Verify adaptive layouts
7. Verify theme preference persistence
8. Verify navigation behavior
9. Verify state restoration
10. Prepare for release

**Expected Outcome:**
- Application is polished
- No fake content
- Flow data matches truth
- All user flows work
- Ready for release

**Validation Criteria:**
- No fake content
- Flow data matches truth
- All flows work
- Accessibility verified
- Adaptive layouts verified
- Theme preference works
- Navigation works
- State restoration works

**Interview Questions After This Milestone:**
- How do you verify release readiness?
- What are common release blockers?
- How do you ensure data accuracy?

**Prerequisites for Moving Forward:**
- Application is release-ready
- Understanding of quality assurance

---

## Conditional Milestones

### Conditional Milestone A: Coroutine Testing Dependencies
**Prerequisite:** Need to test complex coroutine operations
**When to Add:** If testing complex ViewModel logic with coroutines

### Conditional Milestone B: MockK and Turbine
**Prerequisite:** Mocking is necessary (fakes insufficient)
**When to Add:** If fake implementations are insufficient for testing

### Conditional Milestone C: Room Database
**Prerequisite:** Justification for local persistence
**When to Add:** If adding user-generated content or CMS sync

### Conditional Milestone D: Retrofit Networking
**Prerequisite:** Justification for remote data
**When to Add:** If fetching portfolio content from CMS

### Conditional Milestone E: Hilt Dependency Injection
**Prerequisite:** Dependency graph becomes complex
**When to Add:** If multiple repositories and complex dependencies

### Conditional Milestone F: WorkManager
**Prerequisite:** Background sync needed (requires Room + Retrofit)
**When to Add:** If implementing background sync

### Conditional Milestone G: Paging
**Prerequisite:** 50+ items in list
**When to Add:** If large datasets

---

## Current Milestone Status

**Milestone 4: Compose Fundamentals + Static Home Implementation**
- Status: Not Started
