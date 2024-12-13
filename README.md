# Hogwarts Hall

## Implementation

### Architecture

The project follows the **MVVM architecture**. The app is organized into two main modules, as shown below:

<img width=350 src="https://github.com/user-attachments/assets/aeeffda7-e4b9-4735-bac8-7a694581f44a" />

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
