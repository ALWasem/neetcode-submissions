class TreeNode {

    int key;
    int val;

    TreeNode left;
    TreeNode right;

    public TreeNode(int key, int val){
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
    }

}

class TreeMap {

    TreeNode root;

    public TreeMap() {

        this.root = null;
        
    }

    public void insert(int key, int val) {

        TreeNode curr = this.root;
        TreeNode parent = null;

        if(curr == null){
            this.root = new TreeNode(key, val);
            return;
        }

        while(curr != null){
            parent = curr;
            if(key < curr.key)
                curr = curr.left;
            else if(key > curr.key)
                curr = curr.right;
            else{
                curr.val = val;
                return;
            }
                
        }

        if(key < parent.key)
            parent.left = new TreeNode(key, val);
        else   
            parent.right = new TreeNode(key, val);

    }

    public int get(int key) {

        TreeNode curr = this.root;

        while(curr != null){
            if(key < curr.key)
                curr = curr.left;
            else if(key > curr.key)
                curr = curr.left;
            else
                return curr.val;
        }

        return -1;

    }

    public int getMin() {

        TreeNode curr = this.root;

        if(curr == null)
            return -1;

        while(curr.left != null){
            curr = curr.left;
        }

        return curr.val;

    }

    public int getMax() {

        TreeNode curr = this.root;

        if(curr == null)
            return -1;

        while(curr.right != null){
            curr = curr.right;
        }

        return curr.val;

    }

    public void remove(int key) {

        this.root = removeRecursive(this.root, key);
       
    }

    public TreeNode removeRecursive(TreeNode root, int key){

        if(root == null)
            return null;

        if(key < root.key){
            root.left = removeRecursive(root.left, key);
        }
        if(key > root.key){
            root.right = removeRecursive(root.left, key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                TreeNode min = getMinNode(root.right);
                root.key = min.key;
                root.val = min.val;
                root.right = removeRecursive(root.right, min.key);
            }
        }

        return root;

    }

    public TreeNode getMinNode(TreeNode root){

        TreeNode curr = root;
        while(curr != null && curr.left != null)
            curr = curr.left;
        return curr;

    }

    public List<Integer> getInorderKeys() {

        List<Integer> order = new ArrayList<>();

        inOrder(root, order);

        return order;

    }

    public void inOrder(TreeNode root, List<Integer> arr){

        if(root == null)
            return;

        inOrder(root.left, arr);
        arr.add(root.key);
        inOrder(root.right, arr);

    }
}
