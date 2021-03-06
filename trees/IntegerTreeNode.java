public class IntegerTreeNode {
    int value;
    IntegerTreeNode left;
    IntegerTreeNode right;

    public IntegerTreeNode (int n) {
        this.value = n;
        this.left = null;
        this.right = null;
    }

    public void add (int newNumber) {
        if (newNumber > this.value) {
            if (this.right == null) {
                this.right = new IntegerTreeNode(newNumber);
            } else {
                this.right.add(newNumber);
            }
        } else {
            if (this.left == null) {
                this.left = new IntegerTreeNode(newNumber);
            } else {
                this.left.add(newNumber);
            }
        }
    }

    public boolean contains (int n) {
        if (n == this.value) {
            return true;
        } else if (n > this.value) {
            if (this.right == null) {
                return false;
            } else {
                return this.right.contains(n);
            }
        } else {
            if (this.left == null) {
                return false;
            } else {
                return this.left.contains(n);
            }
        }
    }

    public int getMax () {
        if (this.right == null) {
            return this.value;
        } else {
            return this.right.getMax();
        }
    }

    public int getMin () {
        if (this.left == null) {
            return this.value;
        } else {
            return this.left.getMin();
        }
    }

    public String toString(){

        String return_val = "[" + this.value;
        return_val += this.left == null ? " L[] " : " L[ " + this.left.toString() + " ]";
        return_val += this.right == null ? " R[] " : " R[ " + this.right.toString()  + " ]";
        return_val += "]";

        return return_val;
    }

    public int depth () {
        int result = 0;
        int resultLeft = 0;
        int resultRight = 0;

        if (this.left != null) {
            resultLeft += 1 + this.left.depth();
        }
        if (this.right != null) {
            resultRight += 1 + this.right.depth();
        }

        if (resultLeft == 0 && resultRight == 0) {
            return result;
        } else {
            return (resultLeft > resultRight) ? resultLeft : resultRight;
        }
    }
}
