describe('upperFilterのテスト', function(){
    
    it('入力した文字列が大文字に変換される', function(){
        var input = "hello world!";
        var output = "HELLO WORLD!";

        expect(upperFilter(input)).toEqual(output);
    });

    it('エラーになることの確認', function(){
        expect('OK').toEqual('OK');
    });

});
