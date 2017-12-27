<jsp:useBean id="employee" class="com.tbhs.boarding.Employee" scope="request" >
<jsp:setProperty property="*" name="employee"/>
</jsp:useBean>
<jsp:forward page="AddEmployee.do"/>
