import matplotlib.pyplot as pyplot
import numpy

pyplot.style.use('_mpl-gallery')

x = numpy.linspace(0, 10, 100)
y = 1 / numpy.e^(-x)

fig, ax = pyplot.subplots()

ax.plot(x, y, linewidt = 2)

ax.set(xlim = (0, 10), xticks = numpy.arange(1, 10),
       ylim = (0, 10), yticks = numpy.arange(1, 10))
       
pyplot.show()