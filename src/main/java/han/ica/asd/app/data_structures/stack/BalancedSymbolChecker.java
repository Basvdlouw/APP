package han.ica.asd.app.data_structures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class makes use of the HANstack class and checks whether parentheses are being closed properly.
 */
public class BalancedSymbolChecker {

    public enum Symbol {

        OPENING_PARENTHESIS('('), CLOSING_PARENTHESIS(')'),
        OPENING_BRACKET('['), CLOSING_BRACKET(']'),
        OPENING_CURLY_BRACKET('{'), CLOSING_CURLY_BRACKET('}'),
        NOT_A_VALID_SYMBOL('X');

        private final Character character;

        Symbol(Character character) {
            this.character = character;
        }

        public Character getCharacter() {
            return character;
        }
    }

    private static Symbol getSymbolFromChar(Character character) {
        return Arrays
                .stream(Symbol.values())
                .filter(symbol -> symbol.getCharacter() == character)
                .findFirst()
                .orElse(Symbol.NOT_A_VALID_SYMBOL);
    }

    private static List<Symbol> convertCharArrayToSymbolList(char[] chars) {
        final List<Character> listC = new ArrayList<>();
        for (char c : chars) {
            listC.add(c);
        }
        final List<Symbol> symbols = new ArrayList<>();
        listC
                .stream()
                .map(BalancedSymbolChecker::getSymbolFromChar)
                .filter(symbol -> symbol != Symbol.NOT_A_VALID_SYMBOL)
                .forEach(symbols::add);
        return symbols;
    }

    public static boolean isBalanced(char[] chars) {
        final HANStack<Symbol> stack = new HANStack<>();
        for (Symbol symbol : convertCharArrayToSymbolList(chars)) {
            if (isOpeningSymbol(symbol)) {
                stack.push(symbol);
            } else {
                if (stack.getSize() == 0)
                    return false;
                if (!isMatchingPair(stack.pop(), symbol))
                    return false;
            }
        }
        return stack.getSize() == 0;
    }

    private static boolean isMatchingPair(Symbol opening, Symbol closing) {
        if (opening == Symbol.OPENING_PARENTHESIS && closing == Symbol.CLOSING_PARENTHESIS)
            return true;
        else if (opening == Symbol.OPENING_BRACKET && closing == Symbol.CLOSING_BRACKET)
            return true;
        else return opening == Symbol.OPENING_CURLY_BRACKET && closing == Symbol.CLOSING_CURLY_BRACKET;
    }

    private static boolean isOpeningSymbol(Symbol symbol) {
        return symbol == Symbol.OPENING_PARENTHESIS || symbol == Symbol.OPENING_BRACKET || symbol == Symbol.OPENING_CURLY_BRACKET;
    }
}

