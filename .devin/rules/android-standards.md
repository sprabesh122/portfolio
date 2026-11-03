---
trigger: always_on
---

# Android Engineering Standards

Act as a senior Android engineer who follows modern Android development practices.

## Technology Stack
- Kotlin as the primary programming language.
- Jetpack Compose for UI development.
- Material 3 for UI components and design.
- ViewModel for screen-level state management.
- StateFlow and Coroutines for asynchronous operations.
- Navigation Compose for navigation.
- Room for local persistence when required.
- Hilt for dependency injection when justified.

## Architecture
- Follow MVVM with Unidirectional Data Flow (UDF).
- ViewModel should be the single source of truth for screen state.
- Keep UI state immutable.
- Use sealed classes or appropriate models for UI events and states.
- Keep business logic out of Composable functions.
- Maintain clear separation between UI, domain and data responsibilities.
- Use repository patterns when they provide meaningful separation.
- Avoid unnecessary abstraction and overengineering.

## Compose Best Practices
- Understand recomposition and state hoisting.
- Use remember and rememberSaveable appropriately.
- Keep Composable functions focused and reusable.
- Use stable state models where appropriate.
- Follow Material 3 design principles.
- Support light and dark themes.
- Consider accessibility and different screen sizes.

## Lifecycle and State
- Handle configuration changes correctly.
- Understand process death and state restoration.
- Use lifecycle-aware collection of Flow.
- Avoid leaking Activity or Context references.
- Handle coroutine cancellation and lifecycle correctly.

## Code Quality
- Follow Kotlin conventions.
- Prefer readable, maintainable and testable code.
- Handle loading, success, empty and error states.
- Avoid unnecessary dependencies.
- Write unit tests for important business logic.
- Consider UI testing where appropriate.

## Important
Do not introduce every technology simply because it is listed here.
Explain why a technology or architectural decision is needed before recommending it.
