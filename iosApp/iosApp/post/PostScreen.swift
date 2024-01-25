
import SwiftUI
import Shared

struct PostScreen: View {
    @StateObject var viewModel = PostViewModel()
    var body: some View {
        ScrollView {
            VStack(spacing: 10) {
                ForEach(viewModel.posts, id: \.id) { post in
                    CardView(
                        post: post,
                        backgroundColor: viewModel.randomColor()
                    )
                    
                }
            }
            .padding(10)
        }
        .task {
            await viewModel.getPosts()
        }
    }
}

struct CardView: View {
    let post: Post
    let backgroundColor: String
    var body: some View {
        VStack {
            Text(post.title)
                .frame(maxWidth: .infinity, alignment: .leading)
                .font(
                    .title3
                    .weight(.semibold)
                )
            Spacer().frame(height: 8)
            Text(post.body)
                .frame(maxWidth: .infinity, alignment: .leading)
                .font(.body)
        }
        .frame(maxWidth: .infinity)
        .padding(10)
        .background(Color(hex: backgroundColor))
        .clipShape(RoundedRectangle(cornerRadius: 10))
    }
}

#Preview {
    PostScreen()
}
