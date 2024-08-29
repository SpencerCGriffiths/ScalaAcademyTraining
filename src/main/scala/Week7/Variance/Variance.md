# Variance
## Covariance, Contravariance, Invariance


Variance is a concept that is used to explain inheritance correlation of Types that have parameters or aguments within them. 

collection Types can be constructed more securely when using Variances 
When using this you sometimes see - and + symbols being used in types

three types of varying factors either, together, against each other, or change or be completely unrelated

+ = moving together
- = moving away/apart
blank = can move either way or not at all 

list by default are covariant


Covariance
varying together
Syntax: Set[+T]

if the class has type parameter T then the covariant notation will be [+T]. The + symbols tells the developer it is a Covariant.
(you can skip the + as scala can infer this)

imagine we have two sets. Set 1 is a sub-type of Set 2. The two Sets are related and therefor the two types are related. Set 2 can be called as the 'generic' type.
(if one type i.e. class extends the other etc.)
(farm is extended by the animals, farm is the super type)


Contravariance
contra- varying against 
Syntax: Set[-T]

Invariance
can change or be compleetly unrelated
Syntax: Set[T]
