%-------------------------
% Exercise 5.3 b)
%-------------------------

% standard basis in R^3
e1 = [1 0 0]';
e2 = [0 1 0]';
e3 = [0 0 1]';

% part i): images (a1, a2, a3) of (e1, e2, e3)
a1 = [1 1 1]';
a2 = [2 0 0]';
a3 = [0 1 0]';

% part i): linear map F represented by matrix A = (a1, a2, a3)
A = [a1 a2 a3];


% part ii): basis (v1,v2,v3)
v1 = [1 0 0]';
v2 = [1 0 1]';
v3 = [0 1 1]';

% part ii): linear map F represented by matrix C
C = [1 1 1;-1 2 1;1 -1 -1]';


%-------------------------
% Exercise 5.4 b)
%-------------------------

% part i): linear map F represented by matrix B
B=[v1 v2 v3];

% part ii): inverse matrix of B
invB = B^(-1);

% part iii): invB*v_i = e_i

% part iv): A*invB = C
