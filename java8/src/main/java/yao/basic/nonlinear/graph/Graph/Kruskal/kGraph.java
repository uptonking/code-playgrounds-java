package yao.basic.nonlinear.graph.Graph.Kruskal;

import Graph.basic.Edge;
import Graph.basic.Graph;

import java.util.ArrayList;
import java.util.Iterator;


public class kGraph extends Graph{
	ArrayList<Edge> edges;
	 
	public kGraph(int vertexNum) {
		super(vertexNum);
		// TODO Auto-generated constructor stub
 
		edges = new ArrayList<Edge>();
	}
	public void addEdge(int a, int b, int v)
	{
		Edge edge= new Edge(a,b,v);
		edges.add(edge);
	}
	public void addEdge(Edge edge)
	{
		if(edge==null) return;
		edges.add(edge);
	}
	public void printEdges()
	{
		for(Iterator< Edge>i = edges.iterator();i.hasNext();)
		{
			Edge edge = i.next();
			System.out.println("Node "+ edge.s+" Node "+edge.e+" Edge " + edge.weight);
		}
		 
	}
	
}
