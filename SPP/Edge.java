public class Edge implements Comparable<Edge>{

    public String vertax;
    public int distance;
    private int weight;

    public Edge(String v,int d){
        this.vertax = v;
        this.distance = d;
    }

    public String toString(){
        return "vertax : " + this.vertax + ", distance :" + this.distance;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }
}
