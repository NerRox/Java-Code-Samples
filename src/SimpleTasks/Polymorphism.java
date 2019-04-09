// Образец полиморфизма
// TODO Исправить ошибку, должо выводить 1 Teamlead 1 Programmer

package SimpleTasks;
class Polymorphism {
    public static void main(String[] args) {
        new Programmer(1);
    }

    public static class TeamLead {
        private int numTeamLead;

        TeamLead(int numTeamLead) {
            this.numTeamLead = numTeamLead;
            employ();
        }

        protected void employ() {
            System.out.println(numTeamLead + " team lead");
        }

    }

    public static class Programmer extends TeamLead {
        private int numProgrammer;

        Programmer(int numProgrammer) {
            super(numProgrammer);
            this.numProgrammer = numProgrammer;
            employ();
        }

        @Override
        protected void employ() {
            System.out.println(numProgrammer + " programmer");
        }
    }
}