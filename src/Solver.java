import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solver {

    private ArrayList<Board> steps;
    /**
     * find a solution to the initial board
     * @param initial Board to solve
     */
    public Solver(Board initial)
    {
        steps = new ArrayList<>();

        PriorityQueue<Board> pq = new PriorityQueue<>();
        pq.add(initial);

        Board state = initial;

        while (!state.isSolved() && pq.size() > 0)
        {
            state = pq.poll();

            steps.add(state);


            pq.addAll(state.neighbors());
        }

        System.out.println(steps);
        System.out.println(steps.size());

        System.out.println(state.numMoves);

        Board backTrack = state;

        while(backTrack != null){
            System.out.println(backTrack);
            backTrack = backTrack.previous;
        }
    }

    /**
     * is the initial board solvable?
     * @return
     */
    public boolean isSolvable()
    {
        return false;
    }

    /**
     * @return min number of moves to solve the initial board; -1 if no such solution.
     *
     */
    public int moves()
    {
        return 0;
    }

    //  read puzzle instance from stdin and print solution to stdout (in format above)
    public static void main(String[] args)
    {
        int[][] testBoard = {
                {4,2,3},
                {1,0,6},
                {7,8,5}
        };
        Board model = new Board(testBoard);
        Solver solver = new Solver(model);


    }
}