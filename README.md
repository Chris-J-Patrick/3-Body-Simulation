# Three-Body Simulation

This project is inspired by the **"Three-Body Problem"** trilogy by Liu Cixin, which explores the complex and fascinating dynamics of celestial bodies under the influence of gravity. This Java-based simulation aims to model a simplified version of the three-body problem, simulating the gravitational interaction between three bodies in a 2D space.

## Features

- Simulates the gravitational interaction between three celestial bodies.
- Real-time rendering of the bodies' movement and collision handling.
- Merges bodies on collision with conservation of momentum.
- Randomly spawns new celestial bodies after collisions.
- Simple and customizable simulation parameters.

## Technologies Used

- **Java**: Core logic and simulation.
- **Swing**: For graphical user interface and rendering.
- **Git**: For version control.
  
## Installation

To run the project on your local machine, follow the steps below:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/three-body-simulation.git
    ```

2. **Open the project in Eclipse or your preferred Java IDE**.

3. **Build and run**:
   - Open the `ThreeBodySimulationMain` class.
   - Run the project as a Java application.

## How to Use

Once the simulation is running, you can observe the three bodies interacting with each other through gravitational forces. The simulation will automatically detect and merge bodies when they collide. A new celestial body will be spawned after a collision.

### Controls

- **Restart**: Reset the simulation by closing and reopening the application.

## Customization

You can easily customize the parameters of the simulation by editing the following values in the `SimulationPanel` class:

- **Scale**: Modify the `SCALE` variable to change the scale of the simulation.
- **Time Step (dt)**: Change the value of `dt` in the `updateSimulation()` method to adjust the speed of the simulation.
- **Initial Conditions**: The initial positions, velocities, and masses of the bodies are randomly generated, but you can modify them in the `initializeBodies()` method if you prefer to set specific starting values.

## Future Improvements

Planned enhancements include:

- **Advanced force calculation algorithms**: We plan to implement more efficient methods for calculating gravitational forces, such as:
  - **Barnes-Hut algorithm**: This approach reduces the complexity of force calculations from \(O(n^2)\) to \(O(n \log n)\), making the simulation scale better for a larger number of bodies.
    
- **Energy conservation and collision physics**: We will introduce more realistic physical behaviors during collisions, such as handling energy loss and momentum conservation. This will allow for more accurate simulations of inelastic collisions and merging of bodies.

- **UI enhancements**: Add controls for adjusting the simulation speed, pausing/resuming the simulation, and resetting the bodies.

- **Improved rendering**: Color-code bodies based on their mass and velocity to provide better visual feedback, along with improved rendering of their movement.

- **Support for larger simulations**: With the advanced force calculation algorithms, we will be able to scale the simulation to support more than just three bodies, potentially simulating entire star clusters.

## Inspiration

This project was inspired by **The Three-Body Problem Trilogy** by Liu Cixin. The series delves into complex celestial mechanics and its implications, prompting me to create this simulation to explore the gravitational interactions described in the books.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- **Java Swing**: For the simple GUI framework.
- **Eclipse IDE**: Used for development.
- **NASA’s Three-Body Problem Research**: For the theoretical background on gravitational interactions.
- **The Three-Body Problem Trilogy**: By Liu Cixin, for inspiring the concept of this project.

---

Feel free to contribute to the project by forking the repository and submitting a pull request!
