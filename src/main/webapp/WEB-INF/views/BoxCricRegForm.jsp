<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Royal's Box Cricket Registration</title>
</head>
<body>
    <h2>Royal's Box Cricket Registration</h2>
    <form action="StudentRegister" method="post">
        Enter Name: <input type="text" name="studentName" value="${StudentNameValue}">
        <span style="color:red">${studentNameError}</span>
        <br><br>
        Enter Playing Type:
        Batsman <input type="radio" name="playingType" value="Batsman" ${playerTypeValue == 'Batsman' ? 'checked' : ''}>
        Bowler <input type="radio" name="playingType" value="Bowler" ${playerTypeValue == 'Bowler' ? 'checked' : ''}>
        AllRounder <input type="radio" name="playingType" value="AllRounder" ${playerTypeValue == 'AllRounder' ? 'checked' : ''}>
        <span style="color:red">${playerTypeError}</span>
        <br><br>
        Enter Food Preference:
        <select name="foodChoice">
            <option value="-1" ${foodPreferenceValue == '-1' ? 'selected' : ''}>---Select your Food Preferences---</option>
            <option value="Regular" ${foodPreferenceValue == 'Regular' ? 'selected' : ''}>Regular</option>
            <option value="Jain" ${foodPreferenceValue == 'Jain' ? 'selected' : ''}>Jain</option>
        </select>
        <span style="color:red">${foodPreferenceError}</span>
        <br><br>
        Drinks:
        RedBull <input type="checkbox" name="drinks" value="RedBull" ${drinkValue.contains('RedBull') ? 'checked' : ''}>
        Coke <input type="checkbox" name="drinks" value="Coke" ${drinkValue.contains('Coke') ? 'checked' : ''}>
        Mountain Dew <input type="checkbox" name="drinks" value="Mountain Dew" ${drinkValue.contains('Mountain Dew') ? 'checked' : ''}>
        Lemon Juice <input type="checkbox" name="drinks" value="Lemon Juice" ${drinkValue.contains('Lemon Juice') ? 'checked' : ''}>
        <span style="color:red">${drinkError}</span>
        <br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
