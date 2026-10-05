# Custom Dynamic Stack Implementation (Java)

A production-grade, memory-optimized implementation of a **LIFO (Last-In, First-Out)** Stack data structure built entirely from scratch using primitive Java arrays. This project was developed independently to bypass the abstractions of built-in collections and master low-level memory allocation, data management constraints, and runtime efficiency.

---

## 🚀 Key Architectural Features

### 1. Amortized O(1) Dynamic Resizing (Expansion)
To eliminate the rigid bounds of static arrays, this structure monitors item allocation metrics. When memory limits are reached (`size >= capacity`), the engine automatically allocates a new memory block, doubles the allocation capacity, and executes a linear element transfer loop. This keeps average operations running at optimal **O(1) constant runtime**.

### 2. Algorithmic Memory Contraction (Trimming)
To prevent internal data memory leaks from vacant references, the engine automatically contracts the physical memory footprint. If the active element count drops to or below **25% (quarter-capacity)** of total limits, the system reduces the layout footprint by **50% (halving capacity)**. This avoids the "Yo-Yo Effect" (performance thrashing) while maintaining tight infrastructure metrics.

### 3. Strict Boundary Interceptors & Security Safety Caps
* **Stack Underflow Interception:** Built using strict **Separation of Concerns**. Passive state methods watch pointer layers. If an illegal extraction is attempted on an empty workspace, the system halts execution safely by throwing a core `EmptyStackException`.
* **Hardware Resource Preservation:** Features an explicit `maxCapacity` safety gate threshold (capped at 1,000,000 elements) to instantly intercept runaway code loops before they consume host machine RAM allocations.

---

## 🛠️ Data Structure Interface API

The custom `MyStack` API consists of the following core engineering methods:
* `void push(Object data)` - Evaluates storage limits, triggers expansion routines if full, updates pointer trackers, and appends incoming elements.
* `Object pop()` - Intercepts underflow states, handles element extraction, decrements tracking bounds, runs memory trimming evaluations, and returns the top object reference.
* `Object peek()` - Safely looks ahead to inspect the active topmost element without mutating the internal index array state.
* `boolean isEmpty()` - Fast, passive helper checking internal pointer tracking parameters.
* `void display()` - Employs a custom `StringBuilder` routine to map the exact internal state layout backwards from `Top -> Bottom`.
