# DevProfile Technical Decisions

## Decision Log

---

### Decision 1: Figma as Design Source of Truth

**Date:** 2026-11-03
**Decision:** Approved Figma design is the visual and product source of truth for this application

**Alternatives Considered:**
- Design from scratch without reference
- Use generic Material 3 design
- Copy other portfolio designs

**Reason for Chosen Approach:**
- Provides concrete visual specification
- Ensures design consistency
- Approved design represents product vision
- Reduces design ambiguity

**Trade-offs:**
- Must follow Figma specifications exactly
- Less design flexibility during implementation
- Clear visual target to achieve

---

### Decision 2: Five Primary Destinations

**Date:** 2026-11-03
**Decision:** Five primary destinations in exact order: Home, Education, Experience, Projects, About

**Alternatives Considered:**
- Four destinations (original plan)
- Six or more destinations
- Different ordering

**Reason for Chosen Approach:**
- Matches approved Figma design
- Covers all portfolio aspects
- Logical progression from personal to professional
- Home as start destination

**Trade-offs:**
- More screens to implement than original 4
- More navigation complexity
- More comprehensive portfolio coverage

---

### Decision 3: Generic ProjectId-Based Nested Navigation

**Date:** 2026-11-03
**Decision:** Nested project destinations accept generic projectId, not Flow-specific

**Alternatives Considered:**
- Hardcode Flow-specific routes
- No nested navigation
- Different navigation pattern per project

**Reason for Chosen Approach:**
- Allows future projects to be added
- Architecturally sound
- Not tied to single project
- Scalable design

**Trade-offs:**
- Slightly more complex than hardcoded
- Requires generic implementation
- Better long-term architecture

---

### Decision 4: Feature-Oriented Package Structure

**Date:** 2026-11-03
**Decision:** Use feature-oriented packages (home, education, experience, projects, about)

**Alternatives Considered:**
- UI-centric packages (screens, components)
- Layer-oriented packages (ui, data, domain)
- Flat package structure

**Reason for Chosen Approach:**
- Clear feature boundaries
- Easier to navigate
- Scales better than UI-centric packages
- Aligns with feature development

**Trade-offs:**
- Different from some Android conventions
- Requires understanding of feature boundaries
- Better for this scale

---

### Decision 5: Pragmatic MVVM/UDF

**Date:** 2026-11-03
**Decision:** Use pragmatic MVVM with unidirectional data flow, avoid unnecessary Clean Architecture ceremony

**Alternatives Considered:**
- Full Clean Architecture with domain/use-case layers
- No architecture, just UI
- MVVM without UDF

**Reason for Chosen Approach:**
- MVVM + UDF provides clear state management
- Avoids unnecessary abstraction layers
- Simpler for this scale
- Still demonstrates architectural knowledge

**Trade-offs:**
- Less abstraction than full Clean Architecture
- Harder to scale to very large apps
- Appropriate for portfolio scale

---

### Decision 6: Static Data Does Not Require Repository/Domain Layers

**Date:** 2026-11-03
**Decision:** Static portfolio content in simple data classes, no repository or domain layers

**Alternatives Considered:**
- Repository pattern for all data
- Domain layer with use cases
- Clean Architecture with multiple layers

**Reason for Chosen Approach:**
- Static content doesn't require data fetching or transformation
- Repository adds unnecessary abstraction for static data
- Simpler codebase easier to understand
- Add layers only when they solve actual problems

**Trade-offs:**
- Less abstraction than full Clean Architecture
- Harder to add remote data later (but can add when needed)
- Simpler is better for this scale

---

### Decision 7: Persistent Three-State Theme Preference Requires DataStore

**Date:** 2026-11-03
**Decision:** DataStore required for SYSTEM/LIGHT/DARK theme preference persistence

**Alternatives Considered:**
- No theme persistence
- SharedPreferences
- In-memory only

**Reason for Chosen Approach:**
- Persistent user state requires DataStore
- System theme support requires Android integration
- Modern replacement for SharedPreferences
- Required for MVP theme preference

**Trade-offs:**
- Adds DataStore dependency
- More complex than in-memory
- Required for proper theme persistence

---

### Decision 8: Per-Tab Navigation/Scroll Restoration

**Date:** 2026-11-03
**Decision:** Preserve scroll position independently for each primary destination

**Alternatives Considered:**
- No scroll restoration
- Single scroll position for all tabs
- Only restore on back navigation

**Reason for Chosen Approach:**
- Better user experience
- Each tab has independent content
- Standard navigation behavior
- Demonstrates lifecycle knowledge

**Trade-offs:**
- More complex state management
- Requires tracking per-tab state
- Better UX

---

### Decision 9: Reusable Components Extracted After Demonstrated Repetition

**Date:** 2026-11-03
**Decision:** Extract reusable components only after repetition is demonstrated, not upfront

**Alternatives Considered:**
- Pre-build complete design system
- Extract all components immediately
- No reusable components

**Reason for Chosen Approach:**
- Avoids premature abstraction
- Components extracted based on actual need
- Simpler initial implementation
- Reduces unnecessary complexity

**Trade-offs:**
- May have some duplication initially
- Refactoring required later
- Better learning progression

---

### Decision 10: Accessibility and Adaptive Layout Are Implementation Requirements

**Date:** 2026-11-03
**Decision:** Accessibility and adaptive layout are required, not optional

**Alternatives Considered:**
- Accessibility as afterthought
- Single layout only
- No adaptive design

**Reason for Chosen Approach:**
- Required for professional apps
- Demonstrates inclusive design
- Required for release readiness
- Common interview topic

**Trade-offs:**
- More implementation effort
- More testing required
- Professional quality

---

### Decision 11: Flow Missing URLs Must Remain Missing

**Date:** 2026-11-03
**Decision:** Do not invent fake URLs, build percentages, achievements, or metrics for Flow

**Alternatives Considered:**
- Add fake demo URLs
- Add fake GitHub links
- Add fake Play Store listings
- Add fake build percentages

**Reason for Chosen Approach:**
- Honesty in portfolio
- No fake content
- Flow data truth must be preserved
- Professional integrity

**Trade-offs:**
- Less impressive without fake data
- Honest representation
- Professional integrity maintained

---

### Decision 12: Interactive Demonstrations Only Where Product Design Requires

**Date:** 2026-11-03
**Decision:** Add interactive demonstrations only where product design actually requires them

**Alternatives Considered:**
- Generic interactive demos for all concepts
- No interactive demonstrations
- Many demos from the start

**Reason for Chosen Approach:**
- Adds value only where needed
- Avoids unnecessary complexity
- Product-driven approach
- Focus on actual requirements

**Trade-offs:**
- Fewer demonstrations
- More targeted value
- Less unnecessary complexity

---

## Future Decisions

This section will be updated as new technical decisions are made during implementation.
