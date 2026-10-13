package Hcl_Assessment2_Corejava_2300320130201;

     abstract class DVD extends LibraryItem {
        private int durationMinutes;

        public DVD(String title, int year, int durationMinutes) {
            super(title, year);
            if (durationMinutes <= 0) {
                throw new IllegalArgumentException("Duration must be positive");
            }
            this.durationMinutes = durationMinutes;
        }

        @Override
        public double lateFee(int daysLate) {
            return daysLate <= 0 ? 0.0 : daysLate * 5.0;
        }

        public int getDurationMinutes() { return durationMinutes; }

        @Override
        public String toString() {
            return "DVD[" + super.toString() + ", " + durationMinutes + " mins]";
        }

}
