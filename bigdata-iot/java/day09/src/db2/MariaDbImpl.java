package db2;

public class MariaDbImpl extends Db {

	@Override
	public void insert() {
		connect();
		System.out.println("MariaDb Inserted");
		close();
	}

	@Override
	public void delete() {
		connect();
		System.out.println("MariaDb Deleted");
		close();
	}

	@Override
	public void update() {
		connect();
		System.out.println("MariaDb Updated");
		close();
	}

	@Override
	public void select() {
		connect();
		System.out.println("MariaDb Selected");
		close();
	}

	@Override
	public void selectAll() {
		connect();
		System.out.println("MariaDb Seleted All");
		close();
	}

}
