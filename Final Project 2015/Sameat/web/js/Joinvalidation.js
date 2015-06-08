 function ValidateForm() {
                var fname=document.joinF.FirstName;
                var lname=document.joinF.LastName;
                var id=document.joinF.ID;
                var addr=document.joinF.Address;
                var city=document.joinF.City;
                var phone=document.joinF.Phone;
                var email=document.joinF.Email;
                var usern=document.joinF.UserName;
                var password=document.joinF.Password;
                
                var err=false;
                
                var alpha=/^[A-Za-z]+$/;
                var idnum=/^[1-9][0-9]{8}$/;
                var pnum=/^[0-9]{10}$/;
                var vemail=/^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*$/;
                var vuname=/^[A-Za-z]{5,12}$/;
                var vpass=/^(?=.{6,12})(?=.*[0-9])(?=.*[-+_=!@#$%^&amp;*()])(?=.*[A-Z])(?=.*[a-z]).+$/;
                
                /*  Check First Name field */
                 if (!fname.value.match(alpha)) {
                    document.getElementById('fnerr').innerHTML="The First Name must be only from letters!";
                    $('#fnerr').show();
                    fname.focus();
                    err=true;
                } else {
                    $('#fnerr').hide();
                }
                if(fname.value == "") {
                    document.getElementById('fnerr').innerHTML="The First Name is required!";
                    $('#fnerr').show();
                    fname.focus();
                    err=true;
                } else if(fname.value.match(alpha)){
                    $('#fnerr').hide();
                }
              
                
                /* Check Last Name field */
                 if (!lname.value.match(alpha)) {
                    document.getElementById('lnerr').innerHTML="The Last Name must be only from letters!";
                    $('#lnerr').show();
                    lname.focus();
                    err=true;
                } else {
                     $('#lnerr').hide();
                }
                 if(lname.value == "") {
                    document.getElementById('lnerr').innerHTML="The Last Name is required!";
                    $('#lnerr').show();
                    lname.focus();
                    err=true;
                } else if(lname.value.match(alpha)) {
                      $('#lnerr').hide();
                }
               
                
               /* Check ID Field */
                if(!id.value.match(idnum)) {
                       document.getElementById('IDerr').innerHTML="The ID must contain exactly 9 digits!";
                    $('#IDerr').show();
                    id.focus();
                    err=true;
                } else {
                     $('#IDerr').hide();
                }
                if(id.value == "") {
                    document.getElementById('IDerr').innerHTML="The ID is required!";
                    $('#IDerr').show();
                    id.focus();
                    err=true;
                } else if(id.value.match(idnum)){
                    $('#IDerr').hide();
                }
                
               /* Check Address Field */
                if(addr.value == "") {
                    document.getElementById('addrerr').innerHTML="The Address is required!";
                    $('#addrerr').show();
                    addr.focus();
                    err=true;
                } else {
                      $('#addrerr').hide();
                }
                
                /* Check City Field */
                if(!city.value.match(alpha)) {
                    document.getElementById('cityerr').innerHTML="The City must contain only letters!";
                    $('#cityerr').show();
                    city.focus();
                    err=true;
                } else {
                     $('#cityerr').hide();
                } 
                if(city.value == "") {
                    document.getElementById('cityerr').innerHTML="The City is required field!";
                    $('#cityerr').show();
                    city.focus();
                    err=true;
                    
                } else if(city.value.match(alpha)) {
                     $('#cityerr').hide();
                }
                
                /* Check Phone Field */
                if(!phone.value.match(pnum)) {
                    document.getElementById('phonerr').innerHTML="The Phone must contain 10 digits!";
                    $('#phonerr').show();
                    phone.focus();
                    err=true;
                } else {
                   $('#phonerr').hide();
                }
                if(phone.value == "") {
                    document.getElementById('phonerr').innerHTML="The Phone is required!";
                    $('#phonerr').show();
                    phone.focus();
                    err=true;
                } else if(phone.value.match(pnum)){
                    $('#phonerr').hide();
                }
                /* Check Email Field */
                if(!email.value.match(vemail)) {
                    document.getElementById('emailerr').innerHTML="The Email format is wrong!";
                    $('#emailerr').show();
                    email.focus();
                    err=true;
                   } else {
                       $('#emailerr').hide();
                   }
                /*Check UserName Field*/
                
                if(!usern.value.match(vuname)) {
                    document.getElementById('usernerr').innerHTML="The User Name format is wrong!";
                    $('#usernerr').show();
                    usern.focus();
                    err=true;
                } else {
                    $('#usernerr').hide();
                }
                if(!password.value.match(vpass)) {
                    document.getElementById('passerr').innerHTML="The Password format is wrong!";
                    $('#passerr').show();
                    password.focus();
                    err=true;                    
                } else {
                    $('#passerr').hide();
                }
                return !err;
            }