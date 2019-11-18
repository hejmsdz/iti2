package traffic;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoTurtle extends BaseTurtle{

	/**
	 * Makes a number of new destinations and then executes a set of commands on the
	 * created destinations.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created destinations
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> hatchDestinations(int number, Closure closure) {
		AgentSet<traffic.relogo.Destination> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Destination");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.Destination){
				result.add((traffic.relogo.Destination)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new destinations and then executes a set of commands on the
	 * created destinations.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created destinations
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> hatchDestinations(int number) {
		return hatchDestinations(number,null);
	}

	/**
	 * Returns an agentset of destinations from the patch of the caller.
	 * 
	 * @return agentset of destinations from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinationsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<traffic.relogo.Destination> result = new AgentSet<traffic.relogo.Destination>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"destination")){
			if (t instanceof traffic.relogo.Destination)
			result.add((traffic.relogo.Destination)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of destinations on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of destinations at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinationsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<traffic.relogo.Destination> result = new AgentSet<traffic.relogo.Destination>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"destination")){
			if (t instanceof traffic.relogo.Destination)
			result.add((traffic.relogo.Destination)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<traffic.relogo.Destination>();
		}
	}

	/**
	 * Returns an agentset of destinations on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of destinations on patch p
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinationsOn(Patch p){
		AgentSet<traffic.relogo.Destination> result = new AgentSet<traffic.relogo.Destination>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"destination")){
			if (t instanceof traffic.relogo.Destination)
			result.add((traffic.relogo.Destination)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of destinations on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of destinations on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinationsOn(Turtle t){
		AgentSet<traffic.relogo.Destination> result = new AgentSet<traffic.relogo.Destination>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"destination")){
			if (tt instanceof traffic.relogo.Destination)
			result.add((traffic.relogo.Destination)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of destinations on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of destinations on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinationsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<traffic.relogo.Destination>();
		}

		Set<traffic.relogo.Destination> total = new HashSet<traffic.relogo.Destination>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(destinationsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(destinationsOn(p));
				}
			}
		}
		return new AgentSet<traffic.relogo.Destination>(total);
	}

	/**
	 * Queries if object is a destination.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a destination
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public boolean isDestinationQ(Object o){
		return (o instanceof traffic.relogo.Destination);
	}

	/**
	 * Returns an agentset containing all destinations.
	 * 
	 * @return agentset of all destinations
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinations(){
		AgentSet<traffic.relogo.Destination> a = new AgentSet<traffic.relogo.Destination>();
		for (Object e : this.getMyObserver().getContext().getObjects(traffic.relogo.Destination.class)) {
			if (e instanceof traffic.relogo.Destination){
				a.add((traffic.relogo.Destination)e);
			}
		}
		return a;
	}

	/**
	 * Returns the destination with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public traffic.relogo.Destination destination(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof traffic.relogo.Destination)
			return (traffic.relogo.Destination) turtle;
		return null;
	}

	/**
	 * Makes a number of new poissonStreams and then executes a set of commands on the
	 * created poissonStreams.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> hatchPoissonStreams(int number, Closure closure) {
		AgentSet<traffic.relogo.PoissonStream> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"PoissonStream");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.PoissonStream){
				result.add((traffic.relogo.PoissonStream)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new poissonStreams and then executes a set of commands on the
	 * created poissonStreams.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> hatchPoissonStreams(int number) {
		return hatchPoissonStreams(number,null);
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
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
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
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> hatchUserTurtles(int number, Closure closure) {
		AgentSet<traffic.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.UserTurtle){
				result.add((traffic.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> hatchUserTurtles(int number) {
		return hatchUserTurtles(number,null);
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
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
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
	 * Returns the value from the getLaneWidth() method of the underlying patch.
	 * 
	 * @return getLaneWidth() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserPatch")
	public java.lang.Object getLaneWidth(){
		traffic.relogo.UserPatch p = (traffic.relogo.UserPatch)patchHere();
		return p.getLaneWidth();
	}

	/**
	 * Calls the setLaneWidth(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserPatch")
	public void setLaneWidth(java.lang.Object value){
		traffic.relogo.UserPatch p = (traffic.relogo.UserPatch)patchHere();
		p.setLaneWidth(value);
	}

	/**
	 * Makes a directed userLink from a turtle to the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public traffic.relogo.UserLink createUserLinkFrom(Turtle t, Closure closure){
		traffic.relogo.UserLink link = (traffic.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public traffic.relogo.UserLink createUserLinkFrom(Turtle t){
			return createUserLinkFrom(t,null);
	}

	/**
	 * Makes directed userLinks from a collection to the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet<traffic.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<traffic.relogo.UserLink> links = new AgentSet<traffic.relogo.UserLink>();
		for(Turtle t : a){
			links.add((traffic.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet<traffic.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a){
		return createUserLinksFrom(a,null);
	}

	/**
	 * Makes a directed userLink to a turtle from the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public traffic.relogo.UserLink createUserLinkTo(Turtle t, Closure closure){
		traffic.relogo.UserLink link = (traffic.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public traffic.relogo.UserLink createUserLinkTo(Turtle t){
			return createUserLinkTo(t,null);
	}

	/**
	 * Makes directed userLinks to a collection from the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet<traffic.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<traffic.relogo.UserLink> links = new AgentSet<traffic.relogo.UserLink>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((traffic.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet<traffic.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a){
		return createUserLinksTo(a,null);
	}

	/**
	 * Queries if there is a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public boolean inUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed userLinks to the caller.
	 * 
	 * @return agentset with directed userLinks to the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet inUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public traffic.relogo.UserLink inUserLinkFrom(Turtle t){
		return (traffic.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed userLinks from other turtles to the caller.
	 * 
	 * @return agentset of directed userLinks from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet<traffic.relogo.UserLink> myInUserLinks(){
		AgentSet<traffic.relogo.UserLink> result = new AgentSet<traffic.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getInEdges(this)){
			if (o instanceof traffic.relogo.UserLink){
				result.add((traffic.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed userLinks to other turtles from the caller.
	 * 
	 * @return agentset of directed userLinks to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet<traffic.relogo.UserLink> myOutUserLinks(){
		AgentSet<traffic.relogo.UserLink> result = new AgentSet<traffic.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getOutEdges(this)){
			if (o instanceof traffic.relogo.UserLink){
				result.add((traffic.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public boolean outUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed userLinks from the caller.
	 * 
	 * @return agentset with directed userLinks from the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet outUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public traffic.relogo.UserLink outUserLinkTo(Turtle t){
		return (traffic.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(this, t);
	}

	/**
	 * Reports true if there is a userLink connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public boolean userLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * userLinks connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet userLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's userLinks.
	 * 
	 * @return agentset of the caller's userLinks
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet<traffic.relogo.UserLink> myUserLinks(){
		AgentSet<traffic.relogo.UserLink> result = new AgentSet<traffic.relogo.UserLink>();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getEdges(this)){
			if (o instanceof traffic.relogo.UserLink){
				result.add((traffic.relogo.UserLink)o);
			}
		}
		return result;
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