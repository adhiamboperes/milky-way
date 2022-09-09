# milky-way
Android app to show images from space using NASA's search API.

NASA's API is known to be slow in retrieving results, and due to the large payload and payload structure, deserializing takes a bit of time.

## Architecture
MVVM with Clean Architecture
- Abstracting business logic from the view model and activities to improve testability
The project structure is grouped as in the diagram:

<img width="828" alt="Screen Shot 2022-09-09 at 11 49 32 PM" src="https://user-images.githubusercontent.com/59600948/189447284-13ed85f0-4f40-4f57-9c00-d0a5abfb9f8e.png">
Image credits [toptal.com](https://www.toptal.com/)

## Technical Considerations
### Sharing data between PhotoListActivity and PhotoDescriptionActivity
- We are using intent extras because the data to be shared are simple strings, which will not impact performance.
- Also Considered the alternative of using in-memory Realm Database, but rejected to relative complexity of testing compared to the selected alternative. It would however be a great option for scaling.

### Image Loading Library
- We are using coil because
  - It is written in kotlin and backed by Kotlin Coroutines, leveraging Kotlin's language features for simplicity and minimal boilerplate
  - It is simple to set up, plug and play
  - It is fast with caching capabilities
- Non-technical consideration - I took the opportunity to learn a new library as opposed to using glide and picasso that I am familiar with.

## Possible improvements
1. Improve loading performance by paginating the search requests
2. Cache images for a short period of time since the information is consistent
