import java.util.*;
public class violin1
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int num_cases = in.nextInt();
        for (int i = 0; i < num_cases; i++)
        {
            int num_notes = in.nextInt();
            int movements = 0;
            int [] notes = new int[num_notes];

            for (int j = 0; j < num_notes; j++)
                notes[j] = in.nextInt();

            boolean [] fingers = new boolean[5];
            movements += (notes[0] == 0)? 0 : 1;
            fingers[notes[0]] = true;

            for (int j = 1; j < num_notes; j++)
            {
                if (notes[j] > notes[j - 1])
                {
                    fingers[notes[j]] = true;
                    movements++;
                }
                else if (notes[j] < notes[j - 1])
                {
                    int temp = notes[j];
                    for (int k = 4; k > temp; k--)
                    {
                        if (fingers[k])
                        {
                            fingers[k] = false;
                            movements++;
                        }
                    }
                    if (fingers[temp] == false && temp != 0)
                    {
                        fingers[temp] = true;
                        movements++;
                    }
                }
            }
            System.out.println(movements);
        }

    }
}
