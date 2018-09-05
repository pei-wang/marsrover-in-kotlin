# MarsRover Kata
```
You are working at Nasa in the team who's building Rover, an autonomous vehicle which explores Mars' surface.

```

### Mission
Mars rover can receive commands from Nasa:
The command sent are:
- M : rover move one step
- L : rover pivots to the left
- R : rover pivots to the right

you can send the commands on continuous character, like `MMMLR` it means operate the rover move
3 steps, turn left and turn right in order.

Rover receives single command:
* given Rover is in coordinate 1 1 N(at point 1,1 orientate north)
* when Rover receives commad M
* then Rover is in coordinate 1 2 N

Rover receives several commands:
* given Rover is in coordinate 1 1 N(at point 1,1 orientate north)
* when Rover receives command MMLLR
* then Rover is in coordinate 1 3 W

extra acceptance criteria:
* given Rover is in coordinate 1 1 N
* when Rover receives command change to coordinate 3 3
* then Rover investigate the point,if investigate success, destroy itself.
