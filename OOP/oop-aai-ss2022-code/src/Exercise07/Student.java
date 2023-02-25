class Student implements Comparable<Student> {
	private int matrikel;
	private String name;

	Student(int m, String n) {
		setMatrikel(m);
		setName(n);
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		if (n == null)
			throw new IllegalArgumentException();
		name = n;
	}

	public int getMatrikel() {
		return matrikel;
	}

	public void setMatrikel(int m) {
		if (m <= 0)
			throw new IllegalArgumentException();
		matrikel = m;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Student))
			return false;

		Student s = (Student) o;

		return this.matrikel == s.matrikel && this.name.equals(s.name);
	}

	@Override
	public String toString() {
		return name + " (" + matrikel + ") [" + this.hashCode() + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.matrikel - o.matrikel;
	}
}
