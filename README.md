# Hogwarts Hall

## Implementation

### Architecture

The project follows the **MVVM architecture**. The app is organized into two main modules, as shown below:

<img width=300 src="https://github.com/user-attachments/assets/84408c4e-a12c-44a8-9837-b6d29f2c83e2" />

This structure includes the following:
- **app**: handles the presentation and domain layers
- **core**: manages the data layer and contains three submodules:
    - **data**: contains the repository and is responsible for managing local and remote data sources
    - **database**: focuses on interacting with the local database
    - **network**: handles communication with the remote service

### Technologies

- Kotlin
- Android Jetpack
    - Compose (with Material Design 3): for building the UIs
    - ViewModel: to manage UI-related data with lifecycle awareness
    - Navigation Component: to navigate between screens
    - Room: for managing the local database
- Coroutines and Flow: to handle asynchronous tasks and data streams
- WorkManager: to handle background tasks in the offline-first approach
- Retrofit: to handle network requests and responses
- Dagger Hilt: as dependency injection framework
- JUnit 5 and Mockito: for the unit tests

### Decisions

- Persistence: **Room** was preferred since it's the best option to handle large and complex datasets.
- Offline First approach:
  - Given the nature of the app, it’s unlikely that the fetched data will change frequently. As a result, it was decided that the database should be the source of truth.
  - To fetch data and synchronize it with the database, a worker was implemented in **WorkManager**, which is scheduled to fetch new information at a defined interval.
  - This makes the user experience smoother by ensuring quick access to data and keeping it available even when there’s no internet connection.

### Considerations and possible enhancements
Below are a few things the app could improve, specially for a production version:

- **Database encryption** to improve security
- More logging, structured to be visible only in debug builds
- Better Gradle file configuration to improve build logic structure
- A new module for features would be a nice addition
- Dispatchers should be injected for better testability
- The project lacks good unit test coverage and UI tests
- The search functionality is not optimized. There are better algorithms to handle this
- Experimental APIs were used, which is not ideal in a commercial app
- The UI was not the focus during development, so it definitely needs some polish :)

