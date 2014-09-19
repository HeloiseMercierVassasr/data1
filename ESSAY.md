data1
=====
Nota Bene: I didnt add a copy of my console transcript because emacs still isn't successfuly working on my mac
despite your help and my efforts, so I can't run my program. I thought about using the computers of the 
department just to run it, but java isn't functionning on the machines yet.


Essay

To test the implementation of my finite sets I decided to define a few methods that checked certain propreties
of the finite sets using methods defined earlier. First of all I created a method to return random finite sets
of integers in which no element was repeated (line 255) - to work with the binary search tree class.
To make it the most eclectic possible the number of elements and the elements themselves are randomly chosen every 
time the method is called.

The first tester method remove/cardinality-checker (line 271) tests the proprety that when an element is removed from a 
finite set, the cardinality of that set is either the same as previously - if the element wasnt in the set- or less - 
if the element was in the set and successfuly removed.This method takes as only input a finite set u, it then generates
a random number between 0 and 10 and creates a new set remove-rand containing all elements of u except for the random 
number (using the remove method). It then compares the cardinality of set u and the set remove-rand. 

The second tester subset/equal-checker (line 285) tests the proprety that equal sets are subsets of each other - since
they both only contain elements that are also in the other set. This methods only takes one input, a finite set t and 
defines a new finite set u which is equal to finite set t - it has the same root, left and right subtree.
We then test that they are both subsets of each other. 

Proprety1-checker (line 295) works on the first proprety you gave us in the assignment descrption. It checks
that if you add an element x to a finite set t and y is member of that set, it is either the case that x = y 
or that y was previously a member of finite set t. The method generates two random integers x and y in a pretty 
narrow interval- 0 to 10 - and add's x to finite set t. I then check if y is a member of the set (add t x), if it 
is I check the to see if either x=y or y was previouslt a member of the finite set t. Since this methods has a 
condition that won't always be met, it may be unconclusive unlike the other testers.

On line 310, I defined a method to check that an element was correctly added to a finite set and that it was successfuly 
detected by the member method. The add/member tester takes as only input a finite set, it then add's a randomly
generated integer to that list. A call to the member method is then made over that random integer. 

The union/member-checker (line 322) takes as inputs two finite sets u and t, and checks that an element 
in the union of sets t and u is either in set t or set u - or both. 
We add to both sets a randomly generated element elt. We then generate the union of those two sets and check 
elt is a member of the set.

The inter/union/cardinality-checker (line 336) compares the length of the intersection of two non-equal sets
and the length of the union of those two sets. The intersection of two sets should always contain less elements 
then the union of two sets - except if those two sets are equal in which case the intersection and the union contain
all same elements. We calculate the cardinality of both the union and the intersection of the two sets and then compare
them. If the cardinality of the intersection is smaller then the union of the two sets OR union cardinality and 
intersection cardinality are the same AND the two sets are equal, the proprety was successfuly proven.

The last tester diff/union/inter/equal-checker (line 350) checks that the union of (diff t u) and (inter u t) is equal
to set u. Indeed since (diff t u) returns the set containing everything in u except elements that are in t and 
(inter u t) returns the set containing all elements both in u and t. So the union of both sets reasembles all the 
elements in either set, thus all elements of set u. The method verifies the equality between the union of (diff t u) 
and (inter u t) and set u.


The main method then generates three random FiniteSet and calls the tester methods.
I also added a test calls on empty finite sets just to be sure they where tested on all "sorts" of finite sets.
