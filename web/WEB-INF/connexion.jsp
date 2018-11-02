<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Connexion</title>
    <link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
<form method="post" action="connexion">
    <fieldset>
        <legend>Connexion</legend>
        <p>Vous pouvez vous connecter via ce formulaire.</p>

        <label for="login">Login <span class="requis"></span></label>
        <input type="login" id="login" name="login" value="<c:out value="${journaliste.login}"/>" size="20" maxlength="60" />
        <span class="erreur">${form.erreurs['login']}</span>
        <br />

        <label for="password">Mot de passe <span class="requis"></span></label>
        <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['password']}</span>
        <br />

        <input type="submit" value="Connexion" class="sansLabel" />
        <br />

        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
    </fieldset>
</form>
</body>
</html>