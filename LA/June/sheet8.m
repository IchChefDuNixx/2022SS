%-------------------------
% Exercise 8.3
%-------------------------
fprintf("\n ----- Exercise 8.3 -----\n\n")

% matrix A
a1 = [1 -1 0]';
a2 = [2 3 1]';
A = [a1 a2]

% matrix B
b1 = [1 0 0]';
b2 = [0 2 0]';
B = [b1 b2]

%   A  =  S  *  B  *  T^(-1)
% (3x2) (3x3) (3x2) (2x2)

% basis \A = \E = ( (1,0)^T, (0,1)^T )
% basis \B = ( a1, 0.5*a2, e1 )

% S = \T^\B_\E'
S = [a1 0.5*a2 b1]
S_B = S*B

% T^(-1) = \T^\E_\A = (2x2)-identity matrix (since \A=\E)
invT = eye(2)
S_B_invT = S*B*invT


%-------------------------
% Exercise 8.4
%-------------------------
fprintf("\n ----- Exercise 8.4 -----\n\n")

A = [1 0 0 0;1 1 0 0;1 1 1 0;1 1 1 1]
invA = [1 0 0 0;-1 1 0 0;0 -1 1 0;0 0 -1 1]

invA_A = invA*A