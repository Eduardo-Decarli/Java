public class Main {
    public static void main(String[] args) {
        DivisionCalculator calculator = new DivisionCalculator();

        // Tratando exceções padrão do Java (ArithmeticException)
        try {
            int result = calculator.divide(10, 0);
            System.out.println("Resultado: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        // Tratando exceções customizadas
        try {
            calculator.validateNumber(-5);
        } catch (CustomException e) {
            System.err.println("Erro customizado: " + e.getMessage());
        }
    }
}
