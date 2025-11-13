# Bonus Task

This project implements the construction of a Minimum Spanning Tree , followed by the removal of a single MST edge. It then identifies the resulting disjoint components and finds an appropriate replacement edge to restore the graph, ensuring it remains a valid minimum spanning tree.

1. Builds the Minimum Spanning Tree  from a given graph using Kruskal’s algorithm.
2. Displays all MST edges before any removal.
3. Removes one chosen edge from the MST.
4. Detects and prints the connected components formed after the removal.
5. Finds the smallest valid replacement edge that reconnects the components.
6. Displays the updated MST and the new total weight.

This demonstrates correct implementation of:
- Union–Find structure  
- MST construction  
- Handling MST edge removal  
- Efficient reconnection of components

## Structure:
<img width="1038" height="1138" alt="image" src="https://github.com/user-attachments/assets/53c770df-0648-4d8e-9978-0fe65e5c69bb" />


## Running Tests
The project includes JUnit tests that verify:
- MST contains exactly `V - 1` edges  
- No cycles are formed  
- Deterministic MST behavior  
- Components are detected correctly after removal  
- Replacement edge is valid and reconnects different components

## Expected output:
<img width="391" height="661" alt="image" src="https://github.com/user-attachments/assets/f5b62e22-d5b7-4abd-a58a-ef89513d4c42" />


##  How to Run the Program

### 1. Clone the repository

```bash
git clone https://github.com/Aiym1703/BONUSTASK11.git
cd BONUSTASK11
```
###
### 3. Run the program

You can run the program directly using Maven:

```bash
mvn exec:java -Dexec.mainClass="org.example.app.Main"
```

## Run tests with:
- mvn clean test



