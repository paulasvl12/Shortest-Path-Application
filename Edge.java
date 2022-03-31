// A class to store a graph edge
    public class Edge {
    
      int source, dest, weight;
  
      public Edge(int source, int dest, int weight)
      {
          this.source = source;
          this.dest = dest;
          this.weight = weight;
      }
  
      // Overrides the default toString() method so prints out in a readable format
      public String toString(){
        return "("+ this.source+ ", "+this.dest + ", "+this.weight + ")";
      }
      
  }