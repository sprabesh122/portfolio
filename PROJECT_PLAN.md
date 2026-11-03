# DevProfile Project Plan

## Design Source of Truth

**Approved Figma design** is the visual and product source of truth for this application.

## Application Concept

**DevProfile** is a professional portfolio application demonstrating Android engineering capability through polished UI, thoughtful architecture, and a single personal project showcase.

## Core Purpose

To showcase professional identity and Android engineering expertise through:
- Professional profile and background
- Education and experience timeline
- Project showcase with technical depth
- Engineering principles and skill catalog
- Accessible, responsive design

## Target Audience

- **Primary:** Technical interviewers, engineering managers, recruiters
- **Secondary:** Fellow developers, tech community

## Problem Solved

Static portfolios don't demonstrate mobile development skills. This app showcases native Android expertise through implementation quality, design polish, and architectural soundness.

## Screen List

### Primary Destinations (5, in order)
1. **Home** - Profile/hero, production impact, recognition preview, daily toolkit, currently-building Flow preview
2. **Education** - Introduction, education summary, NIT Rourkela, KMC, learning journey/timeline
3. **Experience** - Introduction, current employment, promotion milestone, production/engineering impact, engineering highlights, previous role, recognition
4. **Projects** - Introduction, project presentation, Flow concept preview, stack/status, project-detail action, engineering context
5. **About** - Profile, engineering principles, skill catalog, contact destinations, appearance preference selector

### Nested Project Destinations
1. **Project Detail** - Project metadata/status, concept preview, product intent, engineering highlights, architecture/stack, demo status/action, project status
2. **Project Demo Status** - Current Flow state (Unavailable), no fake content

## Navigation Structure

**Bottom Navigation (5 destinations, in order):**
- Home (start destination)
- Education
- Experience
- Projects
- About

**Main Navigation Order:** home → education → experience → projects → about

**Nested Navigation:**
- Projects → Project Detail (accepts projectId)
- Project Detail → Project Demo Status (accepts projectId)

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

**Flow Project:**
- Currently the only personal project
- projectId = "flow"
- Do not architect navigation specifically around Flow
- Project destinations should conceptually accept projectId for future projects

## Main App Shell

Shared across all five primary destinations:
- Portfolio top app bar
- PS identity/monogram
- Screen identity
- Appearance/theme control
- Scrollable content
- Floating five-item bottom navigation

**Nested project screens:**
- Use Back action
- Retain appearance control
- Do NOT show bottom navigation

## State Ownership

**Static Source Data (not mutable UI state):**
- Education
- Experience
- Awards
- Skills
- Projects
- Engineering highlights
- Contact

Keep static source data separate from composables. Use simple Kotlin models/data objects. Do not introduce repositories/domain/use-case layers for static hardcoded portfolio information.

**Real Application State:**
- ThemePreference (SYSTEM, LIGHT, DARK) - persistent user state, requires DataStore
- Navigation/back-stack state - owned by Navigation Compose
- Per-primary-route scroll state - restore independently
- Nested project navigation state (projectId, entry origin) - use SavedStateHandle
- Local component UI state - stays local with remember/rememberSaveable

## Feature Prioritisation

### MVP (Minimum Viable Application)
- Home, Education, Experience, Projects, About screens with static content
- 5-item floating bottom navigation
- Custom design system (approved Figma colors, typography, spacing)
- Static content in data classes (no repositories)
- Theme preference (SYSTEM/LIGHT/DARK) with DataStore
- Nested project navigation with SavedStateHandle

### Intermediate
- ViewModel + StateFlow where mutable state exists
- Reusable Composable components (extracted after demonstrated repetition)
- Per-tab scroll state restoration
- Accessibility hardening
- Adaptive layout for different screen sizes

### Advanced
- ViewModel testing
- Compose UI testing
- Interactive demonstrations (only where product design requires)
- Final polish and release readiness

### Conditional (Add Only If Justified)
- Room Database (only if user-generated content or CMS sync needed)
- Retrofit Networking (only if fetching from remote API)
- Hilt DI (only if dependency graph becomes complex)
- WorkManager (only if background sync needed)
- Paging (only if 50+ items)

## Flow Project Data Truth

Flow is currently:
- id: "flow"
- title: Flow
- subtitle: Automatic Expense Tracker
- status: IN_PROGRESS
- demoUrl: null
- playStoreUrl: null
- sourceUrl: null
- listingVerified: false

**Do not invent:**
- Additional projects
- Build percentages
- Publication status
- Play Store listings
- GitHub/source links
- Demo URLs
- Achievements
- Metrics
