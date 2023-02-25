import numpy

I=[2.3, 1.3, 0.4]
W0 =[[0.2, -1.2],[0.1, -0.1], [-1.0, 0.73]]
W1 =[0.33, -0.2]

def sigmoid(x):
    # your code goes here
    return 1/(1+numpy.exp(-x))

# Neuron 
def neuron(I,W,f):
    # your code goes here
    return f(numpy.dot(I,W))

# Layer 
def layer(I,W):
    # your code goes here
    return neuron(I,W,sigmoid)

H = layer(I, W0)
O = layer(H, W1)
print(H)
print(O)
