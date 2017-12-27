<jsp:useBean id="UpdateEmployee" class="com.tbhs.boarding.Employee" scope="request" >
<jsp:setProperty property="*" name="UpdateEmployee"/>
</jsp:useBean>
<jsp:forward page="UpdateEmployee.do"/>
