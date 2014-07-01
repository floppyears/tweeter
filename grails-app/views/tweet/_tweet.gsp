<!-- Display a tweet -->
<div class="panel panel-default">
    <div class="panel-heading">
        <g:link action="show" id="${tweet.author.id}">@${tweet.author.username}</g:link> - <g:humanDate date="${tweet.dateCreated}" />
    </div>
    <div class="panel-body">
        <p>${tweet.text}</p>
    </div>
</div>