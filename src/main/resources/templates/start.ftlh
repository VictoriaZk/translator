<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<body>

<div class="container" style="margin-left: 100px; margin-right: 100px">
    <div style="padding: 10px; border: 3px solid; margin-top: 50px;">
        <form action="/translator" method="post">
            <textarea type="text" name="inputText" style="width: 600px; height: 400px"></textarea>
            <button type="submit">Translate</button>
        </form>
    </div>
    <#if translate??>
        <div style="padding: 10px; border: 3px solid; margin-top: 50px">
            ${translate.translatedText}
        </div>
        <div style="padding: 10px; border: 3px solid; margin-top: 50px">
            <h3>Слова из базы</h3>
            <#list translate.wordsDB as word>
                <div>
                    ${word.englishWord} -> ${word.word}
                </div>
            </#list>
        </div>
        <div style="padding: 10px; border: 3px solid; margin-top: 50px">
            <h3>Слова из google перевода</h3>
            <#list translate.wordsCloud as word>
                <div>
                    ${word.englishWord} -> ${word.word}
                </div>
            </#list>
        </div>
    </#if>

    <div style="margin-top: 50px; padding: 10px; border: 3px solid;">
        <form action="/translator" method="post" enctype="multipart/form-data">
            <input type="file" name="words" id="words">
            <button type="submit">Add to dataBase</button>
        </form>
    </div>
</div>
</body>
</html>
