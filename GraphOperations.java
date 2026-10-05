import java.util.*;

public class GraphOperations {

    private final Map<String, List<String>> graph;

    public GraphOperations() {
        graph = new LinkedHashMap<>();
    }

    public void addVertex(String vertex) {

        if (graph.containsKey(vertex)) {

            System.out.println(
                    "Vertex already exists."
            );

            return;
        }

        graph.put(
                vertex,
                new ArrayList<>()
        );

        System.out.println(
                "Vertex added: " + vertex
        );
    }

    public void addEdge(
            String source,
            String destination
    ) {

        if (!graph.containsKey(source)
                || !graph.containsKey(destination)) {

            System.out.println(
                    "Both vertices must exist first."
            );

            return;
        }

        if (!graph.get(source)
                .contains(destination)) {

            graph.get(source)
                    .add(destination);
        }

        if (!graph.get(destination)
                .contains(source)) {

            graph.get(destination)
                    .add(source);
        }

        System.out.println(
                "Edge added: "
                        + source
                        + " <-> "
                        + destination
        );
    }

    public void displayGraph() {

        if (graph.isEmpty()) {

            System.out.println(
                    "Graph is empty."
            );

            return;
        }

        System.out.println(
                "\nAdjacency List:"
        );

        for (String vertex :
                graph.keySet()) {

            System.out.println(
                    vertex
                            + " -> "
                            + graph.get(vertex)
            );
        }
    }

    public void bfs(String start) {

        if (!graph.containsKey(start)) {

            System.out.println(
                    "Start vertex not found."
            );

            return;
        }

        Set<String> visited =
                new HashSet<>();

        Queue<String> queue =
                new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        System.out.print(
                "BFS Traversal: "
        );

        while (!queue.isEmpty()) {

            String current =
                    queue.poll();

            System.out.print(
                    current + " "
            );

            for (String neighbour :
                    graph.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);

                    queue.offer(neighbour);
                }
            }
        }

        System.out.println();
    }

    public void dfs(String start) {

        if (!graph.containsKey(start)) {

            System.out.println(
                    "Start vertex not found."
            );

            return;
        }

        Set<String> visited =
                new HashSet<>();

        System.out.print(
                "DFS Traversal: "
        );

        dfsRecursive(
                start,
                visited
        );

        System.out.println();
    }

    private void dfsRecursive(
            String vertex,
            Set<String> visited
    ) {

        visited.add(vertex);

        System.out.print(
                vertex + " "
        );

        for (String neighbour :
                graph.get(vertex)) {

            if (!visited.contains(neighbour)) {

                dfsRecursive(
                        neighbour,
                        visited
                );
            }
        }
    }

    public static void menu(Scanner scanner) {

        GraphOperations graph =
                new GraphOperations();

        int choice;

        do {

            System.out.println(
                    "\n--------------- GRAPH OPERATIONS ---------------"
            );

            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");

            System.out.print(
                    "Enter your choice: "
            );

            choice = Main.readInt(scanner);

            switch (choice) {

                case 1 -> {

                    System.out.print(
                            "Enter vertex name: "
                    );

                    String vertex =
                            scanner.nextLine().trim();

                    if (vertex.isEmpty()) {
                        System.out.println(
                                "Vertex name cannot be empty."
                        );
                    } else {
                        graph.addVertex(vertex);
                    }
                }

                case 2 -> {

                    System.out.print(
                            "Enter source vertex: "
                    );

                    String source =
                            scanner.nextLine().trim();

                    System.out.print(
                            "Enter destination vertex: "
                    );

                    String destination =
                            scanner.nextLine().trim();

                    graph.addEdge(
                            source,
                            destination
                    );
                }

                case 3 -> graph.displayGraph();

                case 4 -> {

                    System.out.print(
                            "Enter starting vertex: "
                    );

                    graph.bfs(
                            scanner.nextLine().trim()
                    );
                }

                case 5 -> {

                    System.out.print(
                            "Enter starting vertex: "
                    );

                    graph.dfs(
                            scanner.nextLine().trim()
                    );
                }

                case 6 -> { }

                default -> System.out.println(
                        "Invalid choice."
                );
            }

        } while (choice != 6);
    }
}