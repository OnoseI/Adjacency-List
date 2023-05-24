import java.io.*; 
import java.util.*; 
//for programming task in assignment 7
public class MainA7 {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in); //create scanner object for user input

        //pass the path to the file as a parameter for each input file
        File file1_1 = new File("C:\\Users\\cromw\\OneDrive\\Documents\\A7.1.txt");
        Scanner sc1_1 = new Scanner(file1_1);
        File file2_1 = new File("C:\\Users\\cromw\\OneDrive\\Documents\\A7.2.txt");
        Scanner sc2_1 = new Scanner(file2_1);

        //user input for switch case (file 1 or file 2)
        int choice; 
        System.out.print("Enter 1 for file one, enter 2 for file 2: ");
        choice = input.nextInt();

        int count; //stores the number of nodes in the graph

        switch(choice){
            case 1: 
                count = sc1_1.nextInt(); //read the first line of the file to get the number of nodes
                Adj_List_GraphA7 graph1_1 = new Adj_List_GraphA7(count); //create a graph object with the number of nodes
                //create second graph with count - used to add edges without addiional comparing newly added edges
                Adj_List_GraphA7 graph1_2 = new Adj_List_GraphA7(count);
                //read the rest of the file to get the edges. The file is a 3 by 3 matrix 
                //where we use file contents to create the edges of the graph
                for(int i = 0; i < count; i++){
                    for(int j = 0; j < count; j++){
                        int temp = sc1_1.nextInt();
                        if(temp == 1){
                            graph1_1.addEdge(i, j);
                            graph1_2.addEdge(i, j);
                        }
                    }

                }
                graph1_1.printGraph(); //print the graph
                System.out.println(); 

                //compare node paths with triple nested for loop. If there is a path from node i to node j and from node j to node k
                //then there is a path from node i to node k
                for(int i = 0; i < count; i++){
                    for(int j = 0; j < count; j++){
                        for(int k = 0; k < count; k++){
                            if(graph1_1.adj.get(i).contains(j) && graph1_1.adj.get(j).contains(k)){
                                System.out.println("There is a path from node " + i + " to node " + k);
                                graph1_2.addEdge(i, k);
                            }
                        }
                    }
                }

                System.out.println();
                graph1_2.printGraph(); //print the graph
                break; 
            case 2: 
                count = sc2_1.nextInt(); //read the first line of the file to get the number of nodes
                //do the same as case 1 but use the second file
                Adj_List_GraphA7 graph2_1 = new Adj_List_GraphA7(count);
                //create second graph with count - used to add edges without addiional comparing newly added edges
                Adj_List_GraphA7 graph2_2 = new Adj_List_GraphA7(count);


                for(int i = 0; i < count; i++){
                    for(int j = 0; j < count; j++){
                        int temp = sc2_1.nextInt();
                        if(temp == 1){
                            graph2_1.addEdge(i, j);
                            graph2_2.addEdge(i, j);
                        }
                    }
                }

                graph2_1.printGraph(); //print the graph
                System.out.println();

                //compare node paths with triple nested for loop. If there is a path from node i to node j and from node j to node k
                //then there is a path from node i to node k
                for(int i = 0; i < count; i++){
                    for(int j = 0; j < count; j++){
                        for(int k = 0; k < count; k++){
                            if(graph2_1.adj.get(i).contains(j) && graph2_1.adj.get(j).contains(k)){
                                System.out.print("There is a path from node " + i + " to node " + k);
                                //print path from node i to node k
                                System.out.println(" --- Path: " + i + " -> " + j + " -> " + k);
                                graph2_2.addEdge(i, k);
                            }
                        }
                    }
                }

                System.out.println();
                graph2_2.printGraph(); //print the graph
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }
}
