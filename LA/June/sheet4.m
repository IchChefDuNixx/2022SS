%-------------------------
% Exercise 4.1
%-------------------------

% part a)
A = [0 1 2;-1 0 2;1 1 1;2 0 -1]
B = [2 0 0 2;-1 0 2 0;1 1 1 1]

% part a): (reduced) row echolon form
Aref = rref(A) % --> Gaussian elimination
Bref = rref(B) % --> Gaussian elimination

% part b): matrix with rows v_i
C = [0 0 0 2 -1;0 1 -2 1 0; ...
  0 -1 2 1 -1;0 0 0 1 2]
Cref = rref(C) % --> Gaussian elimination
% Basis is given by the (transposed) non-zero rows of Cref.
 

%-------------------------
% Exercise 4.2
%-------------------------

% part a)
AB = A*B
BA = B*A

% part b)
C1 = [1 -1 2;0 3 5;1 8 -7]
C2 = [-1 0 1 0;0 1 0 -1;1 0 -1 0]
C3 = [1;0;8;-7]
C4 = [-1 2 0 8]
C5 = [1 4;0 5;6 8]

% part b): valid combinations
C1C1 = C1*C1
C1C2 = C1*C2
C1C5 = C1*C5
C2C3 = C2*C3
C3C4 = C3*C4
C4C3 = C4*C3


%-------------------------
% Exercise 4.3
%-------------------------

% part a): test matrix A
A = [2 3 5 7;11 13 17 19; ...
  23 29 31 37;41 43 47 53]
lambda = 2

% part a).i)
A
lambda
L1 = [1 0 0 0;0 1 0 0; ...
  0 0 lambda 0;0 0 0 1]
L1A = L1*A

% part a).ii)
A
lambda
L2 = [1 0 0 0;0 1 0 0; ...
  0 0 1 0;lambda 0 0 1]
L2A = L2*A

% part a).iii)
A
lambda
L3 = [1 0 0 0;0 0 0 1; ...
  0 0 1 0;0 1 0 0]
L3A = L3*A

% part b): A and E
A = [2 0 -1;1 0 2;-2 1 0]
e1 = [1 0 0]';
e2 = [0 1 0]';
e3 = [0 0 1]';
E = [e1 e2 e3]

% part b): B is the inverse matrix of A
A_E = [A E]
E_B = rref([A E]) % --> Gaussian elimination
B = E_B(:,4:6) % B = A^(-1)
AB = A*B
BA = B*A
