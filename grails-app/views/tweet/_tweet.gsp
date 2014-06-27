<!-- Display a tweet -->
<div>
    <div>
        <g:link action="show" id="${tweet.author.id}">${tweet.author.username}</g:link> @ ${tweet.createDate}
    </div>
    <p>${tweet.text}</p>
</div>