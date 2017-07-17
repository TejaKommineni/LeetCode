import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

enum STATUS
{
VISITED,VISTING,NOT_VISITED	
}

class Graph
{
int vertices;

LinkedList edges[];

STATUS visited[];

Graph(int vertices)
{
this.vertices=vertices;
edges = new LinkedList[vertices];
visited= new STATUS[vertices];
Arrays.fill(visited,STATUS.NOT_VISITED);
for(int i=0;i<vertices;i++)
{
edges[i]= new LinkedList();	
}
}

public void addEdge(int i, int j)
{
edges[i].add(j);	
}

public void DFS(int i) {
	
	if(visited[i]==STATUS.VISITED)
		return ;
	visited[i]=STATUS.VISITED;
	
	System.out.println(i+" ");
	for(int j=0;j<edges[i].size();j++)
	{
		int next =(int)edges[i].get(j);
		if(visited[next]!=STATUS.VISITED)
		{
			DFS(next);
		}
		
	}
	
}

public void BFS(int i) {
	if(visited[i]==STATUS.VISITED)
		return ;
	if(visited[i]!=STATUS.VISTING)
	System.out.println(i);
	
	visited[i]=STATUS.VISITED;
	ArrayList nodes= new ArrayList();
	for(int j=0;j<edges[i].size();j++)
	{
		if(visited[(int)edges[i].get(j)]!=STATUS.VISTING && visited[(int)edges[i].get(j)]!=STATUS.VISITED)
		{ nodes.add(edges[i].get(j));		
			System.out.println(edges[i].get(j));
		visited[(int)edges[i].get(j)]=STATUS.VISTING;}
	}
	
	for(int j=0;j<nodes.size();j++)
	{
		BFS((int)nodes.get(j));
		
	}
	
	
}

public boolean detectCycle(int i) {
	
	if(visited[i]==STATUS.VISITED)
		return false;
	
	visited[i]=STATUS.VISTING;
	for(int j=0;j<edges[i].size();j++)
	{
		if(visited[(int)edges[i].get(j)]==STATUS.VISTING)
		return true;
		boolean returnValue=detectCycle((int)edges[i].get(j));		
		if(returnValue)
			return true;
			
		visited[(int)edges[i].get(j)]=STATUS.VISITED;
	}
	visited[i]=STATUS.VISITED;
	return false;
}

}

public class GraphSearch {
	
	public static void main(String[] args) {
		
		Graph g = new Graph(4);
		g.addEdge(1, 0);
        //g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        //g.addEdge(3, 3);
        //g.DFS(2);
        //g.BFS(2);
        System.out.print(g.detectCycle(2));
	}
}
