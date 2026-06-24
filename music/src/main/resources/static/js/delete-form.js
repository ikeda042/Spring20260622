document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.delete-form').forEach(function (form) {
        form.addEventListener('submit', function (event) {
            if (!confirm('本当に削除しますか？')) {
                event.preventDefault();
            }
        });
    });
});
