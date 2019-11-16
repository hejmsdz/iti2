package traffic;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoPatch extends BasePatch{

	/**
	 * Sprouts (makes) a number of new poissonStreams and then executes a set of commands on the
	 * created poissonStreams.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> sproutPoissonStreams(int number, Closure closure) {
		AgentSet<traffic.relogo.PoissonStream> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"PoissonStream");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.PoissonStream){
				result.add((traffic.relogo.PoissonStream)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new poissonStreams and then executes a set of commands on the
	 * created poissonStreams.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> sproutPoissonStreams(int number) {
		return sproutPoissonStreams(number,null);
	}

	/**
	 * Returns an agentset of poissonStreams from the patch of the caller.
	 * 
	 * @return agentset of poissonStreams from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreamsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<traffic.relogo.PoissonStream> result = new AgentSet<traffic.relogo.PoissonStream>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"poissonStream")){
			if (t instanceof traffic.relogo.PoissonStream)
			result.add((traffic.relogo.PoissonStream)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of poissonStreams on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of poissonStreams at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreamsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<traffic.relogo.PoissonStream> result = new AgentSet<traffic.relogo.PoissonStream>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"poissonStream")){
			if (t instanceof traffic.relogo.PoissonStream)
			result.add((traffic.relogo.PoissonStream)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<traffic.relogo.PoissonStream>();
		}
	}

	/**
	 * Returns an agentset of poissonStreams on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of poissonStreams on patch p
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreamsOn(Patch p){
		AgentSet<traffic.relogo.PoissonStream> result = new AgentSet<traffic.relogo.PoissonStream>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"poissonStream")){
			if (t instanceof traffic.relogo.PoissonStream)
			result.add((traffic.relogo.PoissonStream)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of poissonStreams on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of poissonStreams on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreamsOn(Turtle t){
		AgentSet<traffic.relogo.PoissonStream> result = new AgentSet<traffic.relogo.PoissonStream>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"poissonStream")){
			if (tt instanceof traffic.relogo.PoissonStream)
			result.add((traffic.relogo.PoissonStream)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of poissonStreams on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of poissonStreams on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreamsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<traffic.relogo.PoissonStream>();
		}

		Set<traffic.relogo.PoissonStream> total = new HashSet<traffic.relogo.PoissonStream>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(poissonStreamsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(poissonStreamsOn(p));
				}
			}
		}
		return new AgentSet<traffic.relogo.PoissonStream>(total);
	}

	/**
	 * Queries if object is a poissonStream.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a poissonStream
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public boolean isPoissonStreamQ(Object o){
		return (o instanceof traffic.relogo.PoissonStream);
	}

	/**
	 * Returns an agentset containing all poissonStreams.
	 * 
	 * @return agentset of all poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreams(){
		AgentSet<traffic.relogo.PoissonStream> a = new AgentSet<traffic.relogo.PoissonStream>();
		for (Object e : this.getMyObserver().getContext().getObjects(traffic.relogo.PoissonStream.class)) {
			if (e instanceof traffic.relogo.PoissonStream){
				a.add((traffic.relogo.PoissonStream)e);
			}
		}
		return a;
	}

	/**
	 * Returns the poissonStream with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public traffic.relogo.PoissonStream poissonStream(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof traffic.relogo.PoissonStream)
			return (traffic.relogo.PoissonStream) turtle;
		return null;
	}

	/**
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> sproutUserTurtles(int number, Closure closure) {
		AgentSet<traffic.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.UserTurtle){
				result.add((traffic.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> sproutUserTurtles(int number) {
		return sproutUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<traffic.relogo.UserTurtle> result = new AgentSet<traffic.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof traffic.relogo.UserTurtle)
			result.add((traffic.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<traffic.relogo.UserTurtle> result = new AgentSet<traffic.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof traffic.relogo.UserTurtle)
			result.add((traffic.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<traffic.relogo.UserTurtle>();
		}
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<traffic.relogo.UserTurtle> result = new AgentSet<traffic.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof traffic.relogo.UserTurtle)
			result.add((traffic.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<traffic.relogo.UserTurtle> result = new AgentSet<traffic.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof traffic.relogo.UserTurtle)
			result.add((traffic.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<traffic.relogo.UserTurtle>();
		}

		Set<traffic.relogo.UserTurtle> total = new HashSet<traffic.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<traffic.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof traffic.relogo.UserTurtle);
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtles(){
		AgentSet<traffic.relogo.UserTurtle> a = new AgentSet<traffic.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(traffic.relogo.UserTurtle.class)) {
			if (e instanceof traffic.relogo.UserTurtle){
				a.add((traffic.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public traffic.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof traffic.relogo.UserTurtle)
			return (traffic.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof traffic.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet<traffic.relogo.UserLink> userLinks(){
		AgentSet<traffic.relogo.UserLink> a = new AgentSet<traffic.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(traffic.relogo.UserLink.class)) {
			if (e instanceof traffic.relogo.UserLink){
				a.add((traffic.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public traffic.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (traffic.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public traffic.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}


}