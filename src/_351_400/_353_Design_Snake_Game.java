package _351_400;

/**
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
 * <p>
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * <p>
 * You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
 * <p>
 * Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
 * <p>
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 * <p>
 * Example:
 * <p>
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].
 * <p>
 * Snake snake = new Snake(width, height, food);
 * <p>
 * Initially the snake appears at position (0,0) and the food at (1,2).
 * <p>
 * |S| | |
 * | | |F|
 * <p>
 * snake.move("R"); -> Returns 0
 * <p>
 * | |S| |
 * | | |F|
 * <p>
 * snake.move("D"); -> Returns 0
 * <p>
 * | | | |
 * | |S|F|
 * <p>
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
 * <p>
 * | |F| |
 * | |S|S|
 * <p>
 * snake.move("U"); -> Returns 1
 * <p>
 * | |F|S|
 * | | |S|
 * <p>
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 * <p>
 * | |S|S|
 * | | |S|
 * <p>
 * snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-snake-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _353_Design_Snake_Game {
    //TODO
}
