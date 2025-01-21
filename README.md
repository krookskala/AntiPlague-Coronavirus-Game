
# AntiPlague Coronavirus Game


The AntiPlague Coronavirus Game is a strategic simulation where players prevent a global viral pandemic from infecting the entire world. Inspired by "Plague Inc.," this interactive game challenges players to contain an outbreak using upgrades, strategic decisions, and resource management.

Designed with Java Swing and adhering to the MVC pattern, the game includes dynamic animations, scalable visuals, and multiple difficulty levels to create an immersive experience.

![Image](https://github.com/user-attachments/assets/991d895e-e216-4201-a94a-9d86a68ff268)
![Image](https://github.com/user-attachments/assets/510f3c50-8bb2-4146-9611-12c11f4533c1)
![Image](https://github.com/user-attachments/assets/81524234-120e-4200-911d-689ee5b66510)

![Image](https://github.com/user-attachments/assets/5d7b1794-1c71-49b2-9214-60d02ed91190)
![Image](https://github.com/user-attachments/assets/27c77b7e-e3b3-497b-a4f7-092a822b2267)
![Image](https://github.com/user-attachments/assets/e540f555-513f-4853-9f64-7b600094c11e)


## Table Of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Detailed File Descriptions](#usage)
- [Contributing](#contributing)
- [Links](#links)
- [License](#license)
## Project Overview

The AntiPlague Coronavirus Game is a strategic simulation game where players take on the challenge of preventing a global viral outbreak from infecting the world. Inspired by "Plague Inc.," this interactive application combines strategy, resource management, and quick decision-making to combat a fast-evolving virus.
## Features

**Gameplay**

- **Strategic Virus Containment:** Prevent the virus from spreading across a map of 10+ countries.
- **Dynamic Virus Behavior:** The virus evolves and spreads based on difficulty level and player decisions.
- **Upgrades and Customization:** Purchase from a selection of 9+ upgrades to improve containment efforts.
- **Transport Systems:** Visualize the spread through 3+ travel methods (e.g., air, sea, land) with animations.
- **Dynamic Difficulty Levels:** Choose from at least three levels of difficulty, each affecting virus spread and resource availability.



**Graphical Interface**


- **Main Menu:** Options for "New Game," "High Scores," and "Exit."
- **High Scores with Persistence:** View and save high scores using the Serializable interface, with a scrollable JList display for large records.
- **Interactive Map:** Buttons or custom components represent countries with transport connections visualized through animations.
- **Real-Time Updates:** Constantly updated score and time counters.
- **Scalable Windows:** User-friendly interface with scalable designs for all screens.


**Core Functionalities**


- **Save and Load High Scores:** Players input their names to save scores based on time, effects, and difficulty.
- **Multithreading:** Separate threads for time counter, virus behavior, and game logic.
- **Emergency Exit:** A keyboard shortcut (Ctrl+Shift+Q) allows players to quit the game and return to the main menu.
- **Error Handling:** Comprehensive exception handling with user-friendly messages.

**Technologies Used**


- **Language:** Java
- **Framework:** Swing
- **Design Pattern:** MVC (Model-View-Controller)
- **Persistence:** Serializable Interface for saving high scores
- **Graphics:** Custom animations and graphic files for countries, transport, and UI components
 
 
 
## Getting Started

Follow these instructions to set up the AntiPlague Coronavirus Game on your local machine for development, testing, or deployment.

### Prerequisites

Ensure you have the following software installed on your machine:

- Java Development Kit (JDK) (v8 or higher)
- Git (to clone the repository)
- An IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/krookskala/AntiPlague-Coronavirus-Game

2. **Compile the project**
   ```bash
    javac -d bin src/**/*.java  

3. **Run the application**
   ```bash
    java -cp bin Main  

4. **Access the game**
   ```bash
    The application will launch a graphical interface for the main menu. Select "New Game" to begin playing.

   
### Docker Deployment

1. **Build the Docker image**
   ```bash
   docker build -t anti-plague-game .  

2. **Run the Docker container**
   ```bash
   docker run -p 8080:8080 anti-plague-game  


## Detailed File Descriptions

- **Main.java:** The main entry point of the application. Initializes the game, sets up the graphical user interface (GUI), and manages the application's lifecycle.

- **/model:** Contains classes representing the game's core logic and data, including:

    - **Country.java:** Represents individual countries with attributes like infection rate, population, and connections.

    - **Virus.java:** Handles virus properties, spread mechanics, and upgrades.

    - **Upgrade.java:** Manages purchasable upgrades and their effects.

-  **/view:** Defines the GUI components, including:

    - **MainMenu.java:** The main menu interface with options like "New Game" and "High Scores."

    - **GameWindow.java:** The primary game interface displaying the world map, virus stats, and upgrades.

    - **HighScoresWindow.java:** Displays the scrollable high scores list using JList.

- **/controller:** Implements the application's logic and user interactions:

    - **GameController.java:** Orchestrates the game's flow, including virus spread, scoring, and upgrades.

    - **InputHandler.java:** Manages user input and hotkeys, such as Ctrl+Shift+Q for emergency exits.

- **/resources:** Static assets and configuration files:

    - **/images:** Graphics for the map, countries, transport animations, and the virus.

    - **/config:** Configuration files for customizing game settings, such as difficulty levels and upgrade costs.

- **/utils:** Helper classes and utilities:

    - **TimerUtility.java:** Manages the in-game timer.
    - **FileHandler.java:** Reads and writes high scores using the Serializable interface.
    - **ExceptionHandler.java:** Centralized handling of runtime exceptions with user-friendly error messages.


## Contributing

Contributions are welcome!

If you find any issues or have ideas for improvements, feel free to open an issue or submit a pull request.

Please make sure to follow the project's code of conduct.

1. **Fork the repository**
2. **Create your feature branch (git checkout -b feature/YourFeature)**
3. **Commit your changes (git commit -am 'Add some feature')**
4. **Push to the branch (git push origin feature/YourFeature)**
5. **Open a pull request**



## Links

[![Gmail](https://img.shields.io/badge/ismailsariarslan7@gmail.com-D14836?style=for-the-badge&logo=gmail&logoColor=white)](ismailsariarslan7@gmail.com)

[![instagram](https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/ismailsariarslan/)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ismailsariarslan/)
## License

The code in this repository is licensed under the [MIT License.](https://choosealicense.com/licenses/mit/)

