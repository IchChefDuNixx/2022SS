_Exercise assignment for the course [Introduction to AI (partII)](https://inf-git.fh-rosenheim.de/aai-ai2/hsro-aai-ai2-github-io) in the [Bachelor of AAI](https://www.th-rosenheim.de/en/technology/computer-science-mathematics/applied-artificial-intelligence-bachelors-degree) at [Rosenheim University of Applied Sciences](http://www.th-rosenheim.de)_


# 06 - Tensors and Tensorflow

For this exercise you can find some hints within the provided Jupyter Notebooks.

**Solution is provided within the branch "musterloesung".**

## Exercise 1: Activation Functions

#### a) Sigmoid

Calculate the output of the neural network using `sigmoid` as activation function.

The input vector is I=[2.3, 1.3, 0.4].
The weights between input and hidden layer are W0 =[[0.2, -1.2],[0.1, -0.1], [-1.0, 0.73]].
The weights between hidden and output are W1 =[0.33, -0.2].

Calculate the output value!

#### b) Softmax 
Given the vectors P1= [2.0, 2.3, 4.5, 6.5, 3.2] and P2 =[-2.2, -0.7, 1.2, 0.75, 1.23], please calculate the softmax vector.

Do they sum up to 1? Validate!

## Exercise 2: Loss Functions and hot encoding

Lets say you have created a neural network for multi-class classification. The classes are `dog, cat, horse, bird` (in this order!).  
Your neural network emits as a feed forward result the following logist O=[3.2, 1.3, 0.2, 0.8] for the input `dog`.

a) Calculate the output probabilites with softmax.

b) What is the desired output for input `dog` using `hot encoding`? Define the expected output vector using hot encoding!

c) What is the loss if you use cross-entropy (LCE)? Compare the output if a with b!

d) What is the LCE given the ouput after softmax is O2=[0.93, 0.03, 0.01, 0.02] for the input `dog`? Is it better or not?


## Exercise 2: Something cool with Keras

Apply the MNIST keras to the fashion dataset! How accurate is your result?

MNIST Notebook as a baseline: https://inf-git.fh-rosenheim.de/aai-ai2/06_exercise/-/blob/main/MNIST_in_Keras.ipynb

Start with the fashion notebook:https://inf-git.fh-rosenheim.de/aai-ai2/06_exercise/-/blob/main/Fashion-MLNN-Keras.ipynb 

**OPTIONAL**: Can you increase accuracy? How?
