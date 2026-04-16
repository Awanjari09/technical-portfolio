class SuperClass {
    String message = "Hello from SuperClass!";

    public SuperClass(String msg) {
        this.message = msg;
        System.out.println("SuperClass constructor called. Message: " + this.message);
    }
}

class SubClass extends SuperClass {
    String message = "Hello from SubClass!";

    public SubClass(String superMsg, String subMsg) {
        super(superMsg);
        this.message = subMsg; 
        System.out.println("SubClass constructor called. SubClass message: " + this.message);
    }

    public void displayMessages() {
        System.out.println("\nInside displayMessages() method:");
        System.out.println("SubClass's message (this.message): " + this.message);
        System.out.println("SuperClass's message (super.message): " + super.message);
    }

    public static void main(String[] args) {
        System.out.println("Creating an instance of SubClass...");
        SubClass subObj = new SubClass("Original Super Message", "New Sub Message");
        subObj.displayMessages();
    }
}
