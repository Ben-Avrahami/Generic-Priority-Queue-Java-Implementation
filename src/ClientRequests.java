/**
 * ClientRequests Class
 * @author BenA
 *
 */
public class ClientRequests {
	private String _name;
	private long _id;

	public ClientRequests(String name, long id){
		_name=name;
		_id=id;
	}
	public long getId() {
		return _id;
	}
	public String getName() {
		return _name;
	}
	public boolean equals(Object other) {
		return (this._id == ((ClientRequests) other).getId() && (this._name.equals(((ClientRequests) other).getName())));
	}

}
