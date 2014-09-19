package Data1 {

import java.util*:

public class BST implements FiniteSet{
    
    int root;
    FiniteSet left;
    FinitSet right;
    
    BST(FiniteSet left, int root, FiniteSet right){
        this.left=left;
        this.root=root;
        this.right=right;
    }
    
    
    //Since empty finite sets behave differently then non empty finite sets for
    //a lot of these methods, we will have two classes, one for empty
    //finite set and another for non-empty finite sets.
    
    static class EmptyBST implements BST{
        
        //Returns an empty BST
        EmptyBST(){
        }
        
        //EMPTY : Constructor that returns an object of the class Empty
        
        public BST empty(){
            return new EmptyBST();
        }
        
        //CARDINALITY : Called on a finite set, returns the number
        //of elements in the set.
        
        public int cardinality(){
            return 0;
        }
        
        //ISEMPTYHUH : Called on a finite set and determines if it is
        // empty - contains no elements. Returns a boolean.
        
        public boolean isEmptyHuh(){
            return true;
        }
        
        //MEMBER :  Called on a finite set and takes as only input an integer elt
        //and determines if that integer is in the finite set. Returns a boolean.
        
        public boolean member(int elt){
            return false;
        }
        
        //ADD :  Called on a finite set t and takes as only input an integer elt
        //and returns a set containing all elements in set t and elt .
        
        public FiniteSet add(int elt){
            return new NonEmptyBSt (new EmptyBST(), elt , new EmptyBST());
        }
        
        //REMOVE :  Called on a finite set t and takes as only input an integer elt
        //and returns a set containing all elements of set t except elt.
        
        public FiniteSet remove(int elt){
            return this;
        }
        
        //UNION : Called on a finite set t and takes as only input a finite set u
        //and returns a set containing all elements that are either in set t or set u.
        
        public FiniteSet union(FiniteSet u) {
            return u;
        }
        
        //INTERSECTION : Called on a finite set t and takes as only input a finite set u
        //and returns a set containing all elements that are both in set t and set u.
        
        public FiniteSet inter(FiniteSet u){
            return new EmptyBST;
        }
        
        //DIFFERENCE : Called on a finite set t and takes as only input a finite set u
        //and returns a set containing all elements in u that aren't in t.
        
        public FiniteSet diff(FiniteSet u){
            return u;
        }
        
        //EQUAL : Called on a finite set and takes as only input a finite set
        //and determines if both finite sets have exactly the same elements. Returns a boolean.
        
        public boolean equal(FiniteSet u){
            return set.isEmptyHuh();
        }
        
        //SUBSET: Called on a finite set and takes as only input a finite set u
        // and determines if all elements in the finite set t are in set u. Returns a boolean.
        
        
        public boolean subset(FiniteSet u){
            return true;
        }
        
    }
    
    
    static class NonEmptyBST implements BST{
        int root;
        BST left;
        BST right;
        
        NonEmptyBST(BST left, int root, BST right){
            this.left=left;
            this.root=root;
            this.right=right;
        }
        
        //EMPTY : Should return a new object of the class EmptyBST
        public BST empty(){
            return new EmptyBST();
        }
        
        
        //CARDINALITY : A non empty tree will have a minimum cardinality of one
        // since it necessarily has a root, to which we add the cardinality of
        //the left and right subtree.
        
        public int cardinality(){
            return left.carinality() + right.cardinality() + return 1;
        }
        
        
        //ISEMPTYHUH : This method called on a non empty finite set
        //should always return false
        
        public boolean isEmptyHuh(){
            return false;
        }
        
        
        //MEMBER : If an element is in a binary search tree either
        //it is the root or it is a member of the left or right subtree
        
        public boolean member(int elt){
            return (let==root || left.member(elt) || right.member(elt));
        }
        
        
        //ADD : If the element is already in the tree then you should
        //just return the true. Otherwise it should be compared to the root if
        //it’s smaller then the root then it should be added to the left subtree and
        //if it's bigger then the root then it should be added to the right subtree.
        
        public FiniteSet add(int elt){
            if (elt == root){
                return this;
            } else if (elt < root) {
                return new NonEmptyBST(left.add(elt), root, right);
            } else {
                return new NonEmptyBST(left, root , right.add(elt));
            }
        }
        
        
        //REMOVE : If the element is the root, then it should be removed
        //by returning the union of the two subtrees. Otherwise it should
        //be compared to the root to determine from which subtree it should
        //be removed.
        
        public FiniteSet remove(int elt){
            if (elt == root){
                return left.union(right);
            } else if (elt < root) {
                return new NonEmptyBST(left.remove(elt), root, right);
            } else {
                return new NonEmptyBST(left, root , right.remove(elt));
            }
        }
        
        
        //UNION: The method should return the set containing all
        //elements that are in either trees. But since union only has the
        //"power" to merge two trees, and we need to merge three trees -
        //the two subtrees of the t tree and tree u - so we should
        // merge a merged tree with a another tree. But since this
        //omits the root we should finish by adding it.
        
        public FiniteSet union(FiniteSet u){
            return this.left.union(u.union(this.right).add(this.root));
        }
        
        
        
        //INTER : The method should return a set containing all
        //elements that are in both sets. If the element is in both
        //trees then it should be in the newly created tree. Otherwise
        //the union of both its subtrees should be returned.
        
        public FiniteSet inter(FiniteSet u){
            if(u.membe(root)){
                return new NonEmptyBST(left.inter(u), root, right.inter(u));
            } else {
                return left.inter(u).union(right.inter(u));
            }
        }
        
        
        //DIFF : The method has the same “scanning” mechanism as the intersection
        //method only now when the element of u is a member of the other tree it
        //shouldn’t be in the new tree.
        
        public FiniteSet diff(FiniteSet u){
            if (u.member(root)){
                return left.union(right.diff(u.remove(root));
                                  } else {
                                      return new NonEmptyBST( left.diff(u), root, right.diff(u));
                                  }
                                  }
                                  
                                  //EQUAL : Two sets are equal if and only if they contain the exact same
                                  //elements. And the intersection of two sets that contain the exact
                                  //same elements is equal to the both sets.
                                  
                                  public boolean equal(FiniteSet u){
                    return (this.inter(u) == u);
                }
                                  
                                  
                                  //SUBSET : A set t can only be a subset of set u if it contains only
                                  //elements from set u. If the first element of the set t (the root)
                                  //isn't a member of set u, then return false, otherwise you want to check
                                  //that the right and left subtree of set t are subsets of set u.
                                  
                                  public boolean subset(FiniteSet u){
                    if (! u.member(root)) {
                        return false;
                    } else {
                        return (left.subset(u)).union(right.subset(u));
                    }
                }
                                  
                                  //TESTING
                                  //In order to test the properties implemented in the following methods
                                  //we need to be able to generate random binary search trees.Please find 
                                  //a "persuasive" explanation of the propreties these testers check.
                                  
                                  
                                  
                                  
                                  //This method takes an empty FiniteSet and an integer as input and
                                  //returns the a non empty FiniteSet with cardinality number of elements
                                  //that are between 0 and 100, there will be no repeats in the set.
                                  
                                  
                                  public static FiniteSet RanSet(FiniteSet emptySet, int cardinality){
                    if (cardinality == 0)
                        return emptySet;
                } else {
                    int element = new Random().nextInt(100) + 1;
                    if (!empty.member(element)) {
                        return RanSet(empty.add(element), cardinality-1);
                    } else {
                        return RanSet(empty, cardinality)
                    }
                }
                                  }
                                  
                                  //Checks a proprety of finite sets using remove and cardinality
                                  
                                  public static void remove/cardinality-checker(FiniteSet u){
                    int rand = new Random().nextInt(10) + 1;
                    BST removed-rand = u.remove(rand);
                    if (removed-rand.cardinality() <= u.cardinality()) {
                        System.out.println("The property checker for remove/cardinality was successful")
                    } else {
                        System.out.println("The proprety checker for remove/cardinality was unsucessful")
                    }
                }
                                  
                                  
                                  //Checks a proprety of finite sets using subset
                                  
                                  public static void subset-checker(FiniteSet t){
                    FiniteSet u = new FiniteSet(t.left, t.root, t.right);
                    if (second.subset(this) && this.subset(second)){
                        System.out.println("The property checker for subset was successful")
                    } else {
                        System.out.println("The proprety checker for subset was unsucessful")
                    }
                }
                                  
                                  //Checks the first proprety in assignment description
                                  
                                  public static void proprety1-checker(FiniteSet t ){
                    int x = new Random().nextInt(10) + 1;
                    int y = new Random().nextInt(10) + 1;
                    FiniteSet t_x = t.add(x);
                    if ( (t_x.member(y)) && ( (x==y) || (t_x.member(y)))) {
                        System.out.println("The property checker for proprety1 was successful")
                    } else {
                        System.out.println("The proprety checker for property was unconclusive, please try again")
                    }
                }
                                  
                                  
                                  //Checks a proprety of finite sets using  add and member
                                  
                                  public static void add/member-checker(int elt){
                    this.add(elt);
                    if (this.member(elt)){
                        System.out.println("The property checker for add/member was successful")
                    } else {
                        System.out.println("The proprety checker for add/member was unsucessful")
                    }
                }
                                  
                                  //Checks a proprety of finite sets using union and member
                                  
                                  public static void union/member-checker(FiniteSet u, FiniteSet t){
                    int elt = new Random().nextInt(10) + 1;
                    FiniteSet u_elt = u.add(elt);
                    FiniteSet t_elt = t.add(elt);
                    if ((t_elt.union(u_elt)).member(elt)) {
                        System.out.println("The property checker for union/member was successful")
                    } else {
                        System.out.println("The proprety checker for union/member was unsucessful")
                    }
                }
                                  
                                  //Checks a proprety of finite sets using inter, union and cardinality
                                  
                                  public static void inter/union/cardinality-checker(FiniteSet u, FiniteSet t){
                    int cardinality_inter =  (u.inter(t)).cardinality();
                    int cardinality_union =  (u.union(t)).cardinality();
                    if ((u.equal(t) && (cardinality_union == cardinality_inter))
                        || (cardinality_inter <= cardinality_union)){
                        System.out.println("The property checker for inter/union/cardinality was successful")
                    } else {
                        System.out.println("The proprety checker for inter/union/cardinality was unsucessful")
                    }
                }
                                  
                                  
                                  //Checks a proprety of finite sets using diff, union, inter and equal
                                  
                                  public static void diff/union/inter/equal-checker(FiniteSet u, FiniteSet t){
                    FiniteSet diff = t.diff(u);
                    FiniteSet inter = t.inter(u);
                    FiniteSet unionSet = diff.union(inter);
                    if (unionSet.equal(u)){
                        System.out.println("The property checker for diff/union/inter/equal was successful")
                    } else {
                        System.out.println("The proprety checker for diff/union/inter/equal was unsucessful")
                    }
                }
                                  
                                  
                                  //The main method will make calls to all checkers in order to verify they 
                                  //work correctly 
                                  
                                  public static void main (String[] args){
                    FiniteSet emptySet = new Empty();
                    for (int i = 0; i< 5; i++) {
                        int random = new Random().nextInt(100) + 1;
                        int cardinality1 = new Random().nextInt(10) + 1;
                        int cardinality2 = new Random().nextInt(10) + 1;
                        int cardinality3 = new Random().nextInt(10) + 1;
                        FiniteSet Set1 = RanSet(emptySet, cardinality1);
                        FiniteSet Set2 = RanSet(emptySet, cardinality2);
                        FiniteSet Set3 = RanSet(emptySet, cardinality3);
                        FiniteSet EmptyOne = new Empty();
                        remove/cardinality-checker(Set1);
                        remove/cardinality-checker(Set2);
                        remove/cardinality-checker(Set3);
                        remove/cardinality-checker(EmptyOne);
                        subset-checker(Set1);
                        subset-checker(Set2);
                        subset-checker(Set3);
                        subset-checker(EmptyOne);
                        proprety1-checker(Set1);
                        proprety1-checker(Set2);
                        proprety1-checker(Set3);
                        proprety1-checker(EmptyOne);
                        Set1.add/member-checker(random);
                        Set2.add/member-checker(random);
                        Set3.add/member-checker(random);
                        EmptyOne.add/member-checker(random);
                        union/member-checker(Set1, Set2);
                        union/member-checker(Set1, Set3);
                        union/member-checker(Set3, Set3);
                        union/member-checker(EmptyOne, Set1);
                        union/member-checker(Set3, EmptyOne);
                        inter/union/cardinality-checker(Set2, Set3);
                        inter/union/cardinality-checker(EmptyOne, Set3);
                        inter/union/cardinality-checker(Set1, Set1);
                        inter/union/cardinality-checker(Set2, EmptyOne);
                        diff/union/inter/equal-checked(Set1, Set2);
                        diff/union/inter/equal-checked(Set3, Set1);
                        diff/union/inter/equal-checked(Set2, EmptyOne);
                        diff/union/inter/equal-checked(EmptyOne, Set2);
                    }
                }
                                  
                                  
                    
                                                
                                                
                                                
                                                
                            
