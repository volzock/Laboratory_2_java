class Point3d {

    static class Builder {
        protected double x = 0;
        protected double y = 0;
        protected double z = 0;

        Builder() {}

        public Builder setX(double x) {
            this.x = x;
            return this;
        }

        public Builder setY(double y) {
            this.y = y;
            return this;
        }

        public Builder setZ(double z) {
            this.z = z;
            return this;
        }

        public Point3d createPoint() {
            return new Point3d(this);
        }
    }

    private Point3d(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
    }

    private double x, y, z;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public boolean equals(Point3d anotherPoint) {
        return this.x == anotherPoint.getX() && this.y == anotherPoint.getY() && this.z == anotherPoint.getZ();
    }

    public double distanceTo(Point3d anotherPoint) {
        double x = Math.pow(this.x - anotherPoint.getX(), 2);
        double y = Math.pow(this.y - anotherPoint.getY(), 2);
        double z = Math.pow(this.z - anotherPoint.getZ(), 2);

        return Math.sqrt(x + y + z);
    }
}